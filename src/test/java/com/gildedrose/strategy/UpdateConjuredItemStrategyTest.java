package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateConjuredItemStrategyTest {

    private UpdateConjuredItemStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new UpdateConjuredItemStrategy();
    }

    @Test
    void shouldDecreaseQualityByTwoBeforeSellInExpires() {
        Item item = new Item("Conjured Mana Cake", 3, 10);
        strategy.update(item);
        assertEquals(2, item.sellIn, "SellIn should decrease by 1");
        assertEquals(8, item.quality, "Quality should decrease by 2");
    }

    @Test
    void shouldDecreaseQualityByFourWhenSellInReachesZero() {
        Item item = new Item("Conjured Mana Cake", 1, 10);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should decrease to 0");
        assertEquals(6, item.quality, "Quality should decrease by 4 when sellIn is 0");
    }

    @Test
    void shouldNotDropQualityBelowZero() {
        Item item = new Item("Conjured Mana Cake", 5, 1);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should not go below 0");
    }

    @Test
    void shouldNotDropQualityBelowZeroWhenSellInIsZero() {
        Item item = new Item("Conjured Mana Cake", 1, 3);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should decrease to 0");
        assertEquals(0, item.quality, "Quality should not go below 0 even with -4 drop");
    }
}