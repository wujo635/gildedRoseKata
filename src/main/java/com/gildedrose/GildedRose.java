package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item:items) {
            if (!isSpecialItem(item)) {
                item.quality--;
            } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality++;
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 6) {
                        item.quality += 2;
                    } else if (item.sellIn < 11) {
                        item.quality++;
                    }
                }
            }
            updateSellIn(item);
            if (item.sellIn < 0) {
                if (!isSpecialItem(item)) {
                    item.quality--;
                }
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                }
            }
            correctQualityOutOfBounds(item);
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    private boolean isSpecialItem(Item item) {
        return (item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                || item.name.equals("Sulfuras, Hand of Ragnaros"));
    }

    private void correctQualityOutOfBounds(Item item) {
        item.quality = Math.min(Math.max(item.quality, 0), 50);
    }
}