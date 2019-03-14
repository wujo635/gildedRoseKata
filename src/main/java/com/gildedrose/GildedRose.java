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
        }
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

}