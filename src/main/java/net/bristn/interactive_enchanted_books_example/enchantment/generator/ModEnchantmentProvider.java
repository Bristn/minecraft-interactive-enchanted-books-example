package net.bristn.interactive_enchanted_books_example.enchantment.generator;

import java.util.concurrent.CompletableFuture;

import net.bristn.interactive_enchanted_books_example.enchantment.ModEnchantments;
import net.bristn.interactive_enchanted_books_example.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;

public class ModEnchantmentProvider extends FabricDynamicRegistryProvider {

    public ModEnchantmentProvider(FabricPackOutput output, CompletableFuture<Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.ENCHANTMENT));
    }

    @Override
    public String getName() {
        return "Enchantments";
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key,
            Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var supportedItems = context.lookup(Registries.ITEM).getOrThrow(ModItemTags.EXAMPLE_GROUP);

        // Create the base enchantment
        var cost = Enchantment.dynamicCost(1, 10);
        var definition = Enchantment.definition(supportedItems, 10, 3, cost, cost, 5, EquipmentSlotGroup.HAND);
        var builder = Enchantment.enchantment(definition);

        // Set exclusive set & effect
        builder = builder.exclusiveWith(enchantments.getOrThrow(EnchantmentTags.MINING_EXCLUSIVE));
        builder = builder.withEffect(EnchantmentEffectComponents.KNOCKBACK, new AddValue(LevelBasedValue.perLevel(2.75f)));

        register(context, ModEnchantments.EXAMPLE, builder);
    }
}
