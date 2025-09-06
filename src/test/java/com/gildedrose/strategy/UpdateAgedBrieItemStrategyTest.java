package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateAgedBrieItemStrategyTest {

    private UpdateAgedBrieItemStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new UpdateAgedBrieItemStrategy();
    }

    @Test
    void shouldIncreaseQualityByOneAndDecreaseSellIn() {
        Item item = new Item("Aged Brie", 5, 10);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(11, item.quality, "Quality should increase by 1");
    }

    @Test
    void shouldIncreaseQualityByTwoWhenSellInReachesZero() {
        Item item = new Item("Aged Brie", 1, 10);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should decrease to 0");
        assertEquals(12, item.quality, "Quality should increase by 2 when sellIn is 0");
    }

    @Test
    void shouldNotExceedMaxQuality50() {
        Item item = new Item("Aged Brie", 5, 50);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(50, item.quality, "Quality should not exceed 50");
    }

    @Test
    void shouldNotExceedMaxQualityWhenSellInIsZero() {
        Item item = new Item("Aged Brie", 1, 49);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should decrease to 0");
        assertEquals(50, item.quality, "Quality should not exceed 50");
    }
}