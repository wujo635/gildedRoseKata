package com.gildedrose.itemUpdater;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        item.quality -= 2;
        item.sellIn--;
        correctQualityOutOfBounds(item);
    }
}
