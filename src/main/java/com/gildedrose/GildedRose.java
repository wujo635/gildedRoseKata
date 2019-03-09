package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isSpecialItem(items[i])) {
                items[i].quality--;
            } else if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality++;
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 6) {
                        items[i].quality += 2;
                    } else if (items[i].sellIn < 11) {
                        items[i].quality++;
                    }
                }
            }
            updateSellIn(items[i]);
            if (items[i].sellIn < 0) {
                if (!isSpecialItem(items[i])) {
                    items[i].quality--;
                }
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    items[i].quality = 0;
                }
            }
            correctQualityOutOfBounds(items[i]);
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