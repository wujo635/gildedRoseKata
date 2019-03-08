package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    private void assertQualitySuccess(int expectedQuality, Item item) {
        updateAppQuality(item);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    private void assertSellinSuccess(int expectedSellin, Item item) {
        updateAppQuality(item);
        assertEquals(expectedSellin, app.items[0].sellIn);
    }

    private void updateAppQuality(Item item) {
        this.items = new Item[]{item};
        this.app = new GildedRose(items);
        app.updateQuality();
    }

    @Test
    public void foo() {
        updateAppQuality(new Item("foo", 0, 0));
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldIncreaseAgedBrieQualityOnUpdate() {
        assertQualitySuccess(2, new Item("Aged Brie", 1, 1));
    }

    @Test
    public void shouldDecreaseGeneralItemQualityOnUpdate() {
        assertQualitySuccess(0, new Item("general", 1, 1));
    }

    @Test
    public void shouldNotUpdateSulfurasQuality() {
        assertQualitySuccess(1, new Item("Sulfuras, Hand of Ragnaros", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellByDateLessThan5() {
        assertQualitySuccess(4, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy2IfSellByLessThan10AndGreaterThan5() {
        assertQualitySuccess(3, new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1));
    }

    @Test
    public void shouldDisallowQualityGreaterThan50() {
        assertQualitySuccess(50, new Item("Aged Brie", 1, 50));
    }

    @Test
    public void shouldDisallowQualityLessThanZero() {
        assertQualitySuccess(0, new Item("general", 1, 0));
    }

    @Test
    public void shouldSetBackstagePassQualityToZeroAfterConcert() {
        assertQualitySuccess(0, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1));
    }

    @Test
    public void shouldDecreaseSellinDateOnUpdate() {
        assertSellinSuccess(1, new Item("general", 2, 1));
    }

    @Test
    public void shouldNotUpdateSulfurasSellinDate() {
        assertSellinSuccess(1, new Item("Sulfuras, Hand of Ragnaros", 1, 1));
    }

}
