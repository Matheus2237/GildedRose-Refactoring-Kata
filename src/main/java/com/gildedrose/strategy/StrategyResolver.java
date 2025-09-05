package com.gildedrose.strategy;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

public class StrategyResolver {

    private static final String CONJURED_ITEM = "Conjured Mana Cake";
    private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
    private static final String PASSESS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_ITEM = "Aged Brie";

    private final Map<String, UpdateItemStrategy> strategies;

    public StrategyResolver() {
        this.strategies = new HashMap<>();
        strategies.put(CONJURED_ITEM, new UpdateConjuredItemStrategy());
        strategies.put(SULFURAS_ITEM, new UpdateSulfurasItemStrategy());
        strategies.put(PASSESS_ITEM, new UpdatePassessItemStrategy());
        strategies.put(AGED_ITEM, new UpdateAgedBrieItemStrategy());
    }

    public UpdateItemStrategy resolve(Item item) {
        return strategies.getOrDefault(item.name, new UpdateCommonItemStrategy());
    }
}