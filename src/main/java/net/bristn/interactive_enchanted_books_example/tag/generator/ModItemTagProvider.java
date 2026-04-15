package net.bristn.interactive_enchanted_books_example.tag.generator;

import java.util.concurrent.CompletableFuture;

import net.bristn.interactive_enchanted_books_example.item.ModItems;
import net.bristn.interactive_enchanted_books_example.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.Items;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(Provider registries) {
        valueLookupBuilder(ModItemTags.EXAMPLE_GROUP).add(Items.BOW).add(ModItems.EXAMPLE_ITEM).setReplace(false);
    }
}
