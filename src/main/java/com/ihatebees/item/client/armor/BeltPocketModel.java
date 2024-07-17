package com.ihatebees.item.client.armor;

import com.ihatebees.BeeMod;
import com.ihatebees.item.custom.armor.BeltPocketTrinketItem;
import com.ihatebees.item.custom.armor.HoneyBeltTrinketItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BeltPocketModel extends GeoModel<BeltPocketTrinketItem> {
    private final Identifier model = new Identifier(BeeMod.MODID, "geo/item/beltpocket.geo.json");
    private final Identifier texture = new Identifier(BeeMod.MODID, "textures/item/beltpocketmodel.png");
    private final Identifier animations = new Identifier(BeeMod.MODID, "animations/item/honeybelt.animation.json");


    public Identifier getModelLocation(BeltPocketTrinketItem object) {
        return this.model;
    }


    public Identifier getTextureLocation(BeltPocketTrinketItem object) {
        return this.texture;
    }


    public Identifier getAnimationFileLocation(BeltPocketTrinketItem object) {
        return this.animations;
    }

    @Override
    public Identifier getModelResource(BeltPocketTrinketItem animatable) {
        return this.model;
    }

    @Override
    public Identifier getTextureResource(BeltPocketTrinketItem animatable) {
        return this.texture;
    }

    @Override
    public Identifier getAnimationResource(BeltPocketTrinketItem animatable) {
        return this.animations;
    }
}