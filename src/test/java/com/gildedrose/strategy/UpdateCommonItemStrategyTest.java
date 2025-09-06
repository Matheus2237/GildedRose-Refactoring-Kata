package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateCommonItemStrategyTest {

    private UpdateCommonItemStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new UpdateCommonItemStrategy();
    }

    @Test
    void shouldDecreaseQualityByOneBeforeSellInExpires() {
        Item item = new Item("+5 Dexterity Vest", 5, 10);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(9, item.quality, "Quality should decrease by 1");
    }

    @Test
    void shouldDecreaseQualityByTwoWhenSellInReachesZero() {
        Item item = new Item("Elixir of the Mongoose", 1, 10);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should decrease to 0");
        assertEquals(8, item.quality, "Quality should decrease by 2 when sellIn is 0");
    }

    @Test
    void shouldNotDropQualityBelowZero() {
        Item item = new Item("Elixir of the Mongoose", 5, 0);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should not go below 0");
    }

    @Test
    void shouldNotDropQualityBelowZeroWhenSellInIsZero() {
        Item item = new Item("Elixir of the Mongoose", 1, 1);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should decrease to 0");
        assertEquals(0, item.quality, "Quality should not go below 0 even when sellIn is 0");
    }
}