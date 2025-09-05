package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface UpdateItemStrategy {

    void update(Item item);

    default void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
    }
}