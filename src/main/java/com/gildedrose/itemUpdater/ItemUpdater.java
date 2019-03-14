package com.gildedrose.itemUpdater;

import com.gildedrose.Item;

public abstract class ItemUpdater {
    public abstract void update(Item item);

    protected void correctQualityOutOfBounds(Item item) {
        item.quality = Math.min(Math.max(item.quality, 0), 50);
    }
}
