package com.gildedrose;

import com.gildedrose.itemUpdater.BackstagePassUpdater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassUpdaterTest {
    
    private BackstagePassUpdater updater = new BackstagePassUpdater();

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellInDateLessThan5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1);
        updater.update(item);
        assertEquals(4, item.quality);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy2IfSellInLessThan10AndGreaterThan5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1);
        updater.update(item);
        assertEquals(3, item.quality);
    }

    @Test
    public void shouldSetBackstagePassQualityToZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1);
        updater.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy1IfSellInGreaterThan10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1);
        updater.update(item);
        assertEquals(2, item.quality);
    }

    @Test
    public void shouldIncreaseBackstagePassQualityBy3IfSellInIs5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1);
        updater.update(item);
        assertEquals(4, item.quality);
    }
}
