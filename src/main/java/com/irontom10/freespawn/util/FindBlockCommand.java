package com.irontom10.freespawn.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.concurrent.atomic.AtomicReference;

public class FindBlockCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("findblock")
                .then(Commands.argument("block_id", StringArgumentType.string())
                        .executes(ctx -> findBlock(ctx, StringArgumentType.getString(ctx, "block_id")))));
    }

    private static int findBlock(CommandContext<CommandSourceStack> context, String blockId) {
        ServerLevel world = context.getSource().getLevel();
        Block callerBlock;
        try {
            ResourceLocation id = ResourceLocation.tryParse(blockId); // Use tryParse to avoid deprecation
            if (id == null) {
                context.getSource().sendFailure(Component.literal("Invalid block ID."));
                return 0;
            }
            callerBlock = world.registryAccess().registryOrThrow(BuiltInRegistries.BLOCK.key()).get(id); // Use registryAccess
            if (callerBlock == null) {
                context.getSource().sendFailure(Component.literal("Invalid block ID."));
                return 0;
            }
        } catch (Exception e) {
            context.getSource().sendFailure(Component.literal("Invalid block ID."));
            return 0;
        }

        BlockPos origin = BlockPos.containing(context.getSource().getPosition()); // Convert Vec3 to BlockPos
        int radius = 64;

        AtomicReference<BlockPos> closest = new AtomicReference<>();
        AtomicReference<Double> closestDistance = new AtomicReference<>(Double.MAX_VALUE);

        BlockPos.betweenClosed(origin.offset(-radius, -radius, -radius), origin.offset(radius, radius, radius))
                .forEach(pos -> {
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() == callerBlock) {
                        double dist = pos.distSqr(origin);
                        if (dist < closestDistance.get()) {
                            closestDistance.set(dist);
                            closest.set(pos.immutable());
                        }
                    }
                });

        if (closest.get() != null) {
            context.getSource().sendSuccess(
                    () -> Component.literal("Found " + blockId + " at " + closest.get().toShortString()),
                    false);
        } else {
            context.getSource().sendSuccess(
                    () -> Component.literal("No " + blockId + " found in radius " + radius),
                    false);
        }

        return 1;
    }
}
