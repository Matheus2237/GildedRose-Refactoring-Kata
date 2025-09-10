package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface UpdateItemStrategy {

    default void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    default void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
    }

    void updateQuality(Item item);
}