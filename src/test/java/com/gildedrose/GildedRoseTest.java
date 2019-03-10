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

    private void assertSellInSuccess(int expectedSellIn, Item item) {
        updateAppQuality(item);
        assertEquals(expectedSellIn, app.items[0].sellIn);
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
        assertQualitySuccess(0, new Item("General Item", 1, 1));
    }

    @Test
    public void shouldNotUpdateSulfurasQuality() {
        assertQualitySuccess(1, new Item("Sulfuras, Hand of Ragnaros", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellInDateLessThan5() {
        assertQualitySuccess(4, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy2IfSellInLessThan10AndGreaterThan5() {
        assertQualitySuccess(3, new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1));
    }

    @Test
    public void shouldDisallowQualityGreaterThan50() {
        assertQualitySuccess(50, new Item("Aged Brie", 1, 50));
    }

    @Test
    public void shouldDisallowQualityLessThanZero() {
        assertQualitySuccess(0, new Item("General Item", 1, 0));
    }

    @Test
    public void shouldSetBackstagePassQualityToZeroAfterConcert() {
        assertQualitySuccess(0, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1));
    }

    @Test
    public void shouldDecreaseSellinDateOnUpdate() {
        assertSellInSuccess(1, new Item("General Item", 2, 1));
    }

    @Test
    public void shouldNotUpdateSulfurasSellinDate() {
        assertSellInSuccess(1, new Item("Sulfuras, Hand of Ragnaros", 1, 1));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy1IfSellInGreaterThan10() {
        assertQualitySuccess(2, new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1));
    }

    @Test
    public void shouldDecreaseGeneralItemQualityTwiceAsFastWhenSellInIsNegative() {
        assertQualitySuccess(3, new Item("General Item", -1, 5));
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellInIs5() {
        assertQualitySuccess(4, new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1));
    }

    @Test
    public void shouldDecreaseConjuredItemBy2OnUpdate() {
        assertQualitySuccess(1, new Item("Conjured Item", 1, 3));
    }

}
