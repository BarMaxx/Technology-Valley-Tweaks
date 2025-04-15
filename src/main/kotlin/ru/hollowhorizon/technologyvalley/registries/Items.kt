package ru.hollowhorizon.technologyvalley.registries

import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity
import net.neoforged.neoforge.registries.DeferredRegister
import ru.hollowhorizon.technologyvalley.TechnologyValley

object Items {

    val Items = DeferredRegister.createItems(TechnologyValley.ID)

    val FIRE_IRON = Items.registerItem(
        "fire_iron",
        ::Item,
        Item.Properties()
    )

    val ZANITE_CATALYST = Items.registerItem(
        "zanite_catalyst",
        ::Item,
        Item.Properties()
            .rarity(Rarity.UNCOMMON)
            .stacksTo(1)
    )

}