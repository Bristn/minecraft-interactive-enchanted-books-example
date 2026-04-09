package net.bristn.interactive_enchanted_books_example.tag;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> EXAMPLE_GROUP = registerTag("example_group");

    public static void registerModItemTags() {
        ExampleCommonModInitializer.LOGGER.info("Register ModItemTags for" + ExampleCommonModInitializer.MOD_ID);
    }

    private static TagKey<Item> registerTag(String name) {
        var identifier = Identifier.fromNamespaceAndPath(ExampleCommonModInitializer.MOD_ID, name);
        return TagKey.create(Registries.ITEM, identifier);
    }
}
