package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdatePassessItemStrategyTest {

    private UpdatePassessItemStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new UpdatePassessItemStrategy();
    }

    @Test
    void shouldIncreaseQualityBy1WhenSellInAbove10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        strategy.update(item);
        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy2WhenSellInIs10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        strategy.update(item);
        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy2WhenSellInBetween6And10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 30);
        strategy.update(item);
        assertEquals(6, item.sellIn);
        assertEquals(32, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy3WhenSellInIs5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25);
        strategy.update(item);
        assertEquals(4, item.sellIn);
        assertEquals(28, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy3WhenSellInBetween1And5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30);
        strategy.update(item);
        assertEquals(2, item.sellIn);
        assertEquals(33, item.quality);
    }

    @Test
    void shouldDropQualityTo0WhenSellInIs0() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);
        strategy.update(item);
        assertEquals(0, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void shouldNotIncreaseQualityAbove50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        strategy.update(item);
        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality, "Quality should not exceed 50");
    }

    @Test
    void shouldNotIncreaseQualityAbove50WithMultipleIncrements() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        strategy.update(item);
        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality, "Quality should cap at 50 even with multiple increments");
    }
}