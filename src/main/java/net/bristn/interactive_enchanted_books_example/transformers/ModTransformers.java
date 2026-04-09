package net.bristn.interactive_enchanted_books_example.transformers;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

public class ModTransformers {
    public static void registerModTransformers() {
        ExampleCommonModInitializer.LOGGER.info("Register ModTransformers for" + ExampleCommonModInitializer.MOD_ID);
    }

    public static final ValueTransformer NONE = register("none", value -> {
        return value;
    });

    private static ValueTransformer register(String name, ValueTransformerImpl transformer) {
        var identifier = Identifier.fromNamespaceAndPath(ExampleCommonModInitializer.MOD_ID, name);
        return Registry.register(ValueTransformer.REGISTRY, identifier, new ValueTransformer(transformer));
    }
}