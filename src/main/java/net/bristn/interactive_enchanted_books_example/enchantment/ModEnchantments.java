package net.bristn.interactive_enchanted_books_example.enchantment;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> EXAMPLE = key("example_enchantment");

    public static void registerModEnchantments() {
        ExampleCommonModInitializer.LOGGER.info("Register ModEnchantments for" + ExampleCommonModInitializer.MOD_ID);
    }

    private static ResourceKey<Enchantment> key(String path) {
        var id = Identifier.fromNamespaceAndPath(ExampleCommonModInitializer.MOD_ID, path);
        return ResourceKey.create(Registries.ENCHANTMENT, id);
    }
}
