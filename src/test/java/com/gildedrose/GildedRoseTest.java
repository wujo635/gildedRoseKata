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
    public void shouldIncreaseAgedBrieQualityOnUpdate() {
        this.items = new Item[]{new Item("Aged Brie", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseGeneralItemQualityOnUpdate() {
        this.items = new Item[]{new Item("General Item", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldNotUpdateSulfurasQuality() {
        this.items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellInDateLessThan5() {
        this.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy2IfSellInLessThan10AndGreaterThan5() {
        this.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void shouldDisallowQualityGreaterThan50() {
        this.items = new Item[]{new Item("Aged Brie", 1, 50)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void shouldDisallowQualityLessThanZero() {
        this.items = new Item[]{new Item("General Item", 1, 0)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldSetBackstagePassQualityToZeroAfterConcert() {
        this.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseSellinDateOnUpdate() {
        this.items = new Item[]{new Item("General Item", 2, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void shouldNotUpdateSulfurasSellinDate() {
        this.items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy1IfSellInGreaterThan10() {
        this.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseGeneralItemQualityTwiceAsFastWhenSellInIsNegative() {
        this.items = new Item[]{new Item("General Item", -1, 5)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellInIs5() {
        this.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1)}
        ;
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseConjuredItemBy2OnUpdate() {
        this.items = new Item[]{new Item("Conjured Item", 1, 3)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

}
