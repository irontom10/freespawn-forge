package com.irontom10.freespawn;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.entity.Bee.BeeEntity;
import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.entity.girlfriend.GirlfriendEntity;
import com.irontom10.freespawn.entity.shoe.ShoeEntityRenderer;
import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.item.ModCreativeTabs;
import com.irontom10.freespawn.sound.ModSounds;

import com.irontom10.freespawn.util.ItemPropertiesHandler;
import com.irontom10.freespawn.util.ModAutoEnchants;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(main.MOD_ID)
public class main {
	public static final String MOD_ID = "freespawn";
	private static final Logger LOGGER = LogUtils.getLogger();

	public main(FMLJavaModLoadingContext context) {
		IEventBus modEventBus = context.getModEventBus();
		ModEntities.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModCreativeTabs.register(modEventBus);
		ModSounds.register(modEventBus);

		modEventBus.addListener(this::onEntityAttributeCreation);
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::addCreative);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onRegisterCommands(RegisterCommandsEvent event) {

	}

	private void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(ModEntities.GIRLFRIEND.get(),GirlfriendEntity.createAttributes().build());
		event.put(ModEntities.APPLE_COW.get(), Cow.createAttributes().build());
		event.put(ModEntities.BEE.get(), BeeEntity.createAttributes().build());
		event.put(ModEntities.GOLDEN_APPLE_COW.get(), Cow.createAttributes().build());
		event.put(ModEntities.ENCHANTED_GOLDEN_APPLE_COW.get(), Cow.createAttributes().build());
	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

	// Player tick event handler
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide)
			return;

		ItemStack held = event.player.getMainHandItem();
		if (!held.isEmpty()) {
			String id = ForgeRegistries.ITEMS.getKey(held.getItem()).toString();
			for (MobEffectInstance eff : ItemPropertiesHandler.getItemEffects(id)) {
				if (!event.player.hasEffect(eff.getEffect())) {
					event.player.addEffect(new MobEffectInstance(eff));
				}
			}
		}

		for (ItemStack armor : event.player.getArmorSlots()) {
			if (!armor.isEmpty()) {
				String id = ForgeRegistries.ITEMS.getKey(armor.getItem()).toString();
				for (MobEffectInstance eff : ItemPropertiesHandler.getArmorEffects(id)) {
					if (!event.player.hasEffect(eff.getEffect())) {
						event.player.addEffect(new MobEffectInstance(eff));
					}
				}
			}
		}
	}

	// Item crafted event handler
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		String id = ForgeRegistries.ITEMS.getKey(event.getCrafting().getItem()).toString();
		for (Map.Entry<Enchantment, Integer> entry : ItemPropertiesHandler.getItemEnchants(id).entrySet()) {
			event.getCrafting().enchant(entry.getKey(), entry.getValue());
		}
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {

	}

	// You can use EventBusSubscriber to automatically register all static methods
	// in the class annotated with @SubscribeEvent
	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

		}
	}
}
//
