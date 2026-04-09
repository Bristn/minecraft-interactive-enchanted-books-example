package net.bristn.interactive_enchanted_books_example.particle;

import net.bristn.interactive_enchanted_books_example.ExampleCommonModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModParticles {

    public static final SimpleParticleType EXAMPLE = register("example_particle", FabricParticleTypes.simple());

    public static void registerModParticles() {
        ExampleCommonModInitializer.LOGGER.info("Register ModParticles for" + ExampleCommonModInitializer.MOD_ID);
    }

    private static SimpleParticleType register(String name, SimpleParticleType particle) {
        var identifier = Identifier.fromNamespaceAndPath(ExampleCommonModInitializer.MOD_ID, name);
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, identifier, particle);
    }
}
