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


    // Register one for each event name:
    public static final RegistryObject<SoundEvent> FIGHT1 =
            SOUND_EVENT.register("o_fight1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_fight1")));



    public static final RegistryObject<SoundEvent> FIGHT2 =
            SOUND_EVENT.register("o_fight2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_fight2")));
    // … etc for fight3,4,5,6,7 …

    public static final RegistryObject<SoundEvent> TAUNT1 =
            SOUND_EVENT.register("o_taunt1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_taunt1")));
    // … taunt2,3,4 …

    public static final RegistryObject<SoundEvent> WOOHOO1 =
            SOUND_EVENT.register("o_woohoo1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_woohoo1")));
    // … woohoo2,3,4 …

    public static final RegistryObject<SoundEvent> HAPPY1 =
            SOUND_EVENT.register("o_happy1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_happy1")));
    // … up through HAPPY7 …

    public static final RegistryObject<SoundEvent> HURT1 =
            SOUND_EVENT.register("o_hurt1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_hurt1")));
    // … up through HURT9 …

    public static final RegistryObject<SoundEvent> OW1 =
            SOUND_EVENT.register("o_ow1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_ow1")));
    // … up through OW8 …

    public static final RegistryObject<SoundEvent> DARK =
            SOUND_EVENT.register("o_dark", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_dark")));

    public static final RegistryObject<SoundEvent> RAIN =
            SOUND_EVENT.register("o_rain", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_rain")));
    public static final RegistryObject<SoundEvent> THUNDER =
            SOUND_EVENT.register("o_thunder", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_thunder")));
    public static final RegistryObject<SoundEvent> WATER1 =
            SOUND_EVENT.register("o_water1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_water1")));
    public static final RegistryObject<SoundEvent> WATER2 =
            SOUND_EVENT.register("o_water2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_water2")));

    public static final RegistryObject<SoundEvent> DEATH_GIRL =
            SOUND_EVENT.register("o_death_girlfriend", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_death_girlfriend")));
    public static final RegistryObject<SoundEvent> DEATH_SINGLE =
            SOUND_EVENT.register("o_death_single", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(main.MOD_ID, "o_death_single")));
    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}