package com.ihatebees.item.client.armor;

import com.ihatebees.BeeMod;
import com.ihatebees.item.custom.armor.BeltPocketTrinketItem;
import com.ihatebees.item.custom.armor.CoconutBeltTrinketItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BeltPocketRenderer extends GeoItemRenderer<BeltPocketTrinketItem> {
    public BeltPocketRenderer() {
        //super(new CoconutBeltModel());
        super(new DefaultedItemGeoModel<>(new Identifier(BeeMod.MODID, "beltpocket"))); // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
}
