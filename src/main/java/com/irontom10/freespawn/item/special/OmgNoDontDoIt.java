package com.irontom10.freespawn.item.special;

import com.irontom10.freespawn.world.trees.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.Random;

public class OmgNoDontDoIt extends  Item {
    public OmgNoDontDoIt(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().above();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (!level.isClientSide) {
            RandomSource randomSource = ((ServerLevel) level).getRandom();
            Random random = new Random(randomSource.nextLong()); // FIX HERE
            int directionIndex = random.nextInt(4); // 0: North, 1: East, 2: South, 3: West
            int tree = random.nextInt(8);
            BigRoundTree.generate(level, pos, randomSource);
//            switch (tree) {
//                case 0 -> WindTree.generate(level, pos, directionIndex, random);
//                case 1 -> SkyTree.generate(level, pos, directionIndex, random);
//                case 2 -> ScragglyTree.generate(level, pos, random);
//                case 3 -> ExperienceTree.generate(level, pos, random);
//                case 4 -> SmallTree.generate(level, pos, random);
//                case 5 -> DuplicatorTree.generate(level, pos, random);
//                case 6 -> FairyTree.generate(level, pos, random);
//                case 7 -> FairyCastleTree.generate(level, pos, random);
//            }



            if (!player.isCreative()) {
                stack.shrink(1);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
