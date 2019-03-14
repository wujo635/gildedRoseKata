package com.gildedrose.itemUpdater;

import com.gildedrose.Item;

public class SulfurasUpdater  extends ItemUpdater{

    @Override
    public void update(Item item) {
        item.quality = 80;
    }
}
