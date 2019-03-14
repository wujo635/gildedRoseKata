package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    @Test
    public void foo() {
        this.items = new Item[]{(new Item("foo", 0, 0))};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldUpdateAgedBrie() {
        this.items = new Item[]{new Item("Aged Brie", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void shouldUpdateBackstagePass() {
        this.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void shouldUpdateSulfuras() {
        this.items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void shouldUpdateConjuredItem() {
        this.items = new Item[]{new Item("Conjured Item", 1, 2)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldUpdateGenericItem() {
        this.items = new Item[]{new Item("Generic Item", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
