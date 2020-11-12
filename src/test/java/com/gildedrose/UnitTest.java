package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTest {

    @Test
    void isNormalItemWorking() {
        Item[] items = { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void isNormalItemDegradingTwiceFaster() {
        Item[] items = { new Item("Elixir of the Mongoose", 1, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    void isNormalItemQualityNegative() {
        Item[] items = { new Item("Item", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void isAgedBrieItemQualityIncreasing() {
        Item[] items = { new Item(ItemName.AGED_BRIE, 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, items[0].quality);
    }

    @Test
    void isAgedBrieItemQualityAboveFifty() {
        Item[] items = { new Item(ItemName.AGED_BRIE, 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void isSulfurasItemQualityChanging() {
        Item[] items = { new Item(ItemName.SULFURAS, 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, items[0].quality);
    }

    @Test
    void isBackStagePassesItemQualityIncreasing() {
        Item[] items = { new Item(ItemName.BACKSTAGE, 15, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, items[0].quality);
    }

    @Test
    void isBackStagePassesItemQualityIncreasingTwiceWithTenDaysLast() {
        Item[] items = { new Item(ItemName.BACKSTAGE, 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, items[0].quality);
    }

    @Test
    void isBackStagePassesItemQualityIncreasingTwiceWithFiveDaysLast() {
        Item[] items = { new Item(ItemName.BACKSTAGE, 5, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, items[0].quality);
    }

    @Test
    void isConjuredItemQualityDegradingTwice() {
        Item[] items = { new Item(ItemName.CONJURED, 5, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(21, items[0].quality);
    }
}
