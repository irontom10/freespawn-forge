package com.irontom10.freespawn.item;

import com.irontom10.freespawn.main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, main.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FREESPAWN_TAB =
            CREATIVE_MODE_TABS.register("freespawn", () ->
                    CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 0)
                            .title(Component.literal("Freespawn"))
                            .icon(() -> new ItemStack(ModItems.URANIUM_INGOT.get()))
                            .displayItems((parameters, output) -> {
                                // iterate all your registered items and add them to the tab
                                ModItems.ITEM.getEntries().forEach(itemRO ->
                                        output.accept(itemRO.get().getDefaultInstance())
                                );
                            })
                            .build()
            );

    /** Call this from your main mod constructor. */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}