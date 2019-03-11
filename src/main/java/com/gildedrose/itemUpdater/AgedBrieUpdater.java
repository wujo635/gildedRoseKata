package com.gildedrose.itemUpdater;

import com.gildedrose.Item;

public class AgedBrieUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        item.quality++;
        item.sellIn--;
    }
}
