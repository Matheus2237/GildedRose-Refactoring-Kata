package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateSulfurasItemStrategyTest {

    private UpdateSulfurasItemStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new UpdateSulfurasItemStrategy();
    }

    @Test
    void shouldNotChangeSellInOrQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        strategy.update(item);
        assertEquals(9, item.sellIn, "SellIn should not change for Sulfuras");
        assertEquals(80, item.quality, "Quality should not change for Sulfuras");
    }

    @Test
    void shouldRemainUnchangedWhenSellInIs0() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        strategy.update(item);
        assertEquals(0, item.sellIn, "SellIn should remain 0");
        assertEquals(80, item.quality, "Quality should remain 80");
    }

    @Test
    void shouldRemainUnchangedWhenQualityIsAbove80() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 90);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should remain the same");
        assertEquals(90, item.quality, "Quality should remain unchanged even if >80");
    }

    @Test
    void shouldRemainUnchangedWhenQualityIsBelow80() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 70);
        strategy.update(item);
        assertEquals(4, item.sellIn, "SellIn should remain the same");
        assertEquals(70, item.quality, "Quality should remain unchanged even if <80");
    }
}