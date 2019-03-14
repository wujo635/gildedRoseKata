package com.gildedrose;

import com.gildedrose.itemUpdater.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemUpdater updater;
        for (Item item : items) {
            if (isAgedBrie(item)) {
                updater = new AgedBrieUpdater();
            } else if (isBackstagePass(item)) {
                updater = new BackstagePassUpdater();
            } else if (isSulfuras(item)) {
                updater = new SulfurasUpdater();
            } else if (isConjuredItem(item)) {
                updater = new ConjuredItemUpdater();
            } else {
                updater = new GenericItemUpdater();
            }
            updater.update(item);
            if (!isSulfuras(item)) {
                correctQualityOutOfBounds(item);
            }
        }
    }

    private void updateGenericItem(Item item) {
        item.quality -= (item.sellIn > 0) ? 1 : 2;
        item.sellIn--;
    }

    private void updateBackstagePass(Item item) {
        if (item.sellIn > 10) {
            item.quality += 1;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private void updateAgedBrie(Item item) {
        item.quality++;
        item.sellIn--;
    }

    private boolean isConjuredItem(Item item) {
        return item.name.equals("Conjured Item");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void correctQualityOutOfBounds(Item item) {
        item.quality = Math.min(Math.max(item.quality, 0), 50);
    }
}