package net.bristn.interactive_enchanted_books_example.transformers;

import com.mojang.serialization.Codec;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class ValueTransformer {
    private static final Identifier ID = Identifier.fromNamespaceAndPath(ExampleCommonModInitializer.MOD_ID,
            "value_transformers");
    private static final ResourceKey<Registry<ValueTransformer>> KEY = ResourceKey.createRegistryKey(ID);

    public static final Registry<ValueTransformer> REGISTRY = FabricRegistryBuilder.create(KEY).buildAndRegister();
    public static final Codec<ValueTransformer> CODEC = REGISTRY.byNameCodec();

    private final ValueTransformerImpl transformer;

    public ValueTransformer(ValueTransformerImpl transformer) {
        this.transformer = transformer;
    }

    public float apply(float value) {
        return transformer.apply(value);
    }
}