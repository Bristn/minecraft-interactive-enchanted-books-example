package net.bristn.interactive_enchanted_books_example.item;

import java.util.function.Function;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item EXAMPLE_ITEM = register("example_item", Item::new, new Item.Properties());

    public static void registerModItems() {
        ExampleCommonModInitializer.LOGGER.info("Register ModItems for" + ExampleCommonModInitializer.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> {
            creativeTab.accept(ModItems.EXAMPLE_ITEM);
        });

    }

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        var key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExampleCommonModInitializer.MOD_ID, name));
        T item = itemFactory.apply(settings.setId(key));
        Registry.register(BuiltInRegistries.ITEM, key, item);
        return item;
    }
}
