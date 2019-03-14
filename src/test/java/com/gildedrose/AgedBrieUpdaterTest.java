package com.gildedrose;

import com.gildedrose.itemUpdater.AgedBrieUpdater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieUpdaterTest {

    private AgedBrieUpdater updater = new AgedBrieUpdater();

    @Test
    public void shouldIncreaseAgedBrieQualityOnUpdate() {
        Item item = new Item("Aged Brie", 1, 1);
        updater.update(item);
        assertEquals(2, item.quality);
    }

    @Test
    public void shouldDisallowQualityGreaterThan50() {
        Item item = new Item("Aged Brie", 1, 50);
        updater.update(item);
        assertEquals(50, item.quality);
    }
}
