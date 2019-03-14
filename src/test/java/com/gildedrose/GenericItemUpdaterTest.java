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
}
