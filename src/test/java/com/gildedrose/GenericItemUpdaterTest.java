package com.gildedrose;

import com.gildedrose.itemUpdater.GenericItemUpdater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenericItemUpdaterTest {

    private GenericItemUpdater updater = new GenericItemUpdater();

    @Test
    public void shouldDecreaseGeneralItemQualityOnUpdate() {
        Item item = new Item("Generic Item", 1, 1);
        updater.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldDecreaseGeneralItemQualityTwiceAsFastWhenSellInIsNegative() {
        Item item = new Item("Generic Item", -1, 5);
        updater.update(item);
        assertEquals(3, item.quality);
    }

    @Test
    public void shouldDisallowQualityLessThanZero() {
        Item item = new Item("Generic Item", 1, 0);
        updater.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldDecreaseSellinDateOnUpdate() {
        Item item = new Item("Generic Item", 2, 1);
        updater.update(item);
        assertEquals(1, item.sellIn);
    }
}
