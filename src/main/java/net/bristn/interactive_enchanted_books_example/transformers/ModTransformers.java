package net.bristn.interactive_enchanted_books_example.transformers;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class ModTransformers {
    private static final Identifier ID = Identifier.fromNamespaceAndPath("interactive_enchanted_books", "value_transformers");

    public static void registerModTransformers() {
        ExampleCommonModInitializer.LOGGER.info("Register ModTransformers for" + ExampleCommonModInitializer.MOD_ID);
    }

    /**
     * Get or registers the registry for the value transformers. If another mod
     * implements a value transformer, the load order of the mods might differ. This
     * ensures that the first loaded mod creates the registry and the others can
     * access it without a redefinition error
     */
    @SuppressWarnings("unchecked")
    private static Registry<Function<Float, Float>> getOrCreateRegistry() {
        var ref = BuiltInRegistries.REGISTRY.get(ID);
        if (ref.isEmpty()) {
            var key = ResourceKey.createRegistryKey(ID);
            var registry = (Object) FabricRegistryBuilder.create(key).buildAndRegister();
            return (Registry<Function<Float, Float>>) registry;
        }

        return (Registry<Function<Float, Float>>) ref.get().value();
    }

    public static Codec<Function<Float, Float>> getCodec() {
        var registry = getOrCreateRegistry();
        return registry.byNameCodec();
    }

    // ! Transformers

    public static final Function<Float, Float> EXAMPLE = register("example_level_transform", level -> {
        return level * 5;
    });

    // ! Helpers

    private static Function<Float, Float> register(String name, Function<Float, Float> transformer) {
        var identifier = Identifier.fromNamespaceAndPath("interactive_enchanted_books", name);
        var registry = getOrCreateRegistry();
        return Registry.register(registry, identifier, transformer);
    }
}