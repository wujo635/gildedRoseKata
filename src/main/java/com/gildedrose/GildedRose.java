package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                updateAgedBrie(item);
            } else if (isBackstagePass(item)) {
                updateBackstagePass(item);
            } else if (!isSulfuras(item)) {
                updateGenericItem(item);
            }
            correctQualityOutOfBounds(item);
        }
    }

    private void updateGenericItem(Item item) {
        item.quality--;
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality--;
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.sellIn > 0) {
            item.quality += 3 - Math.min(2, item.sellIn / 5);
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private void updateAgedBrie(Item item) {
        item.quality++;
        item.sellIn--;
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