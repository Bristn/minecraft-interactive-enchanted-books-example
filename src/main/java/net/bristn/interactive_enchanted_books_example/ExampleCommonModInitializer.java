package net.bristn.interactive_enchanted_books_example;

import net.bristn.interactive_enchanted_books_example.enchantment.ModEnchantments;
import net.bristn.interactive_enchanted_books_example.item.ModItems;
import net.bristn.interactive_enchanted_books_example.particle.ModParticles;
import net.bristn.interactive_enchanted_books_example.tag.ModItemTags;
import net.bristn.interactive_enchanted_books_example.transformers.ModTransformers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleCommonModInitializer implements ModInitializer {
    public static final String MOD_ID = "interactive_enchanted_books_example";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModParticles.registerModParticles();
        ModItemTags.registerModItemTags();
        ModItems.registerModItems();
        ModEnchantments.registerModEnchantments();
        ModTransformers.registerModTransformers();
    }
}
