package net.bristn.interactive_enchanted_books_example;

import net.bristn.interactive_enchanted_books_example.particle.ModParticles;

import net.bristn.interactive_enchanted_books_example.particle.ExampleParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;

public class ExampleClientModInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(ModParticles.EXAMPLE, ExampleParticle.ColorProvider::new);
    }
}
