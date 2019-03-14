package com.gildedrose;

import com.gildedrose.itemUpdater.SulfurasUpdater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasUpdaterTest {

    private SulfurasUpdater updater = new SulfurasUpdater();

    @Test
    public void sulfurasQualityShouldAlwaysBe80() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 1);
        updater.update(item);
        assertEquals(80, item.quality);
    }

    @Test
    public void shouldNotUpdateSulfurasSellinDate() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 1);
        updater.update(item);
        assertEquals(1, item.sellIn);
    }
}
