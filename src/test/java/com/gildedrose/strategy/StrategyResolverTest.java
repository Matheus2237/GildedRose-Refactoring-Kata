package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyResolverTest {

    private final StrategyResolver resolver = StrategyResolver.getInstance();

    @Test
    void shouldReturnConjuredStrategy() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        UpdateItemStrategy strategy = resolver.resolve(item);
        assertInstanceOf(UpdateConjuredItemStrategy.class, strategy);
    }

    @Test
    void shouldReturnSulfurasStrategy() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        UpdateItemStrategy strategy = resolver.resolve(item);
        assertInstanceOf(UpdateSulfurasItemStrategy.class, strategy);
    }

    @Test
    void shouldReturnPassesStrategy() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30);
        UpdateItemStrategy strategy = resolver.resolve(item);
        assertInstanceOf(UpdatePassessItemStrategy.class, strategy);
    }

    @Test
    void shouldReturnAgedBrieStrategy() {
        Item item = new Item("Aged Brie", 2, 10);
        UpdateItemStrategy strategy = resolver.resolve(item);
        assertInstanceOf(UpdateAgedBrieItemStrategy.class, strategy);
    }

    @Test
    void shouldReturnCommonStrategyForUnknownItem() {
        Item item = new Item("Random Sword", 3, 6);
        UpdateItemStrategy strategy = resolver.resolve(item);
        assertInstanceOf(UpdateCommonItemStrategy.class, strategy);
    }

    @Test
    void shouldAlwaysReturnSameInstanceForSingleton() {
        StrategyResolver first = StrategyResolver.getInstance();
        StrategyResolver second = StrategyResolver.getInstance();
        assertSame(first, second, "StrategyResolver should be a singleton");
    }
}
