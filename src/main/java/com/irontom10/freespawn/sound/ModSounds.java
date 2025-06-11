package com.irontom10.freespawn.sound;

import com.irontom10.freespawn.main;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    // Deferred register on the mod bus:
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, main.MOD_ID);


    //girlfriend sounds
    public static final RegistryObject<SoundEvent> GIRLFIREND_FIGHT =
            SOUND_EVENT.register("girlfriend_fight",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_fight"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_TAUNT =
            SOUND_EVENT.register("girlfriend_taunt",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_taunt"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_WOOHOO =
            SOUND_EVENT.register("girlfriend_woohoo",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_woohoo"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_HAPPY =
            SOUND_EVENT.register("girlfriend_happy",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_happy"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_HURT =
            SOUND_EVENT.register("girlfriend_hurt",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_hurt"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_OW =
            SOUND_EVENT.register("girlfriend_ow",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_ow"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_THUNDER =
            SOUND_EVENT.register("girlfriend_thunder",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_thunder"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_RAIN =
            SOUND_EVENT.register("girlfriend_rain",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_rain"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_DARK =
            SOUND_EVENT.register("girlfriend_dark",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_dark"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_WATER =
            SOUND_EVENT.register("girlfriend_water",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_water"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_DEATH =
            SOUND_EVENT.register("girlfriend_death_girlfriend",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_death_girlfriend"))
            );
    public static final RegistryObject<SoundEvent> GIRLFIREND_DEATH_SINGLE =
            SOUND_EVENT.register("girlfriend_death_single",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "girlfriend_death_single"))
            );
    
    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}