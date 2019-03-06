package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    @Test
    public void foo() {
        items = new Item[]{new Item("foo", 0, 0)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldIncreaseAgedBrieQualityOnUpdate() {
        items = new Item[]{new Item("Aged Brie", 1, 1)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

}
