package com.gildedrose;

import com.gildedrose.itemUpdater.ConjuredItemUpdater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredItemUpdaterTest {

    private ConjuredItemUpdater updater = new ConjuredItemUpdater();

    @Test
    public void shouldDecreaseConjuredItemBy2OnUpdate() {
        Item item = new Item("Conjured Item", 1, 3);
        updater.update(item);
        assertEquals(1, item.quality);
    }
}
