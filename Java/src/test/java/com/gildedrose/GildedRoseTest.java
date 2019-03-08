package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    private void assertSuccess(int expectedQuality, Item item) {
        this.items = new Item[]{item};
        this.app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    public void foo() {
        items = new Item[]{new Item("foo", 0, 0)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldIncreaseAgedBrieQualityOnUpdate() {
        assertSuccess(2, new Item("Aged Brie", 1, 1));
    }

    @Test
    public void shouldDecreaseGeneralItemQualityOnUpdate() {
        assertSuccess(0, new Item("general", 1, 1));
    }

    @Test
    public void shouldNotUpdateSulfurasQuality() {
        assertSuccess(1, new Item("Sulfuras, Hand of Ragnaros", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellByDateLessThan5() {
        assertSuccess(4, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy2IfSellByLessThan10AndGreaterThan5() {
        assertSuccess(3, new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1));
    }

    @Test
    public void shouldDisallowQualityGreaterThan50() {
        assertSuccess(50, new Item("Aged Brie", 1, 50));
    }

    @Test
    public void shouldDisallowQualityLessThanZero() {
        assertSuccess(0, new Item("general", 1, 0));
    }

    @Test
    public void shouldSetBackstagePassQualityToZeroAfterConcert() {
        assertSuccess(0, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1));
    }

}
