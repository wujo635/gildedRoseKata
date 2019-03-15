package com.gildedrose;

import com.gildedrose.itemUpdater.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private static final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    static {
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaterMap.put("Conjured Item", new ConjuredItemUpdater());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (updaterMap.containsKey(item.name)) {
                updaterMap.get(item.name).update(item);
            } else {
                ItemUpdater updater = new GenericItemUpdater();
                updater.update(item);
            }
        }
        //TODO check all bounds of each special item
    }

}