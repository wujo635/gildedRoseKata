package com.gildedrose.itemUpdater;

import com.gildedrose.Item;

public class GenericItemUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.sellIn < 0) {
            item.quality -= 2;
        } else {
            item.quality--;
        }
        item.sellIn--;
        correctQualityOutOfBounds(item);
    }
}
