package de.pnku.mstv_base;

import de.pnku.mstv_base.item.MoreStickVariantItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoreStickVariants implements ModInitializer {

	public static final String MOD_ID = "mstv-base";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	
	@Override
	public void onInitialize() {
		MoreStickVariantItems.registerStickItems();
		ResourceManagerHelper.registerBuiltinResourcePack(
				ResourceLocation.fromNamespaceAndPath(MOD_ID, "pale_oak_experimental"),
				FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
	}

	public static ResourceLocation asId(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

}
