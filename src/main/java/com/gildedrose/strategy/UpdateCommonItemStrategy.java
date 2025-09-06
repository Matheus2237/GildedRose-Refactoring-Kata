package com.gildedrose.strategy;

import com.gildedrose.Item;

public class UpdateCommonItemStrategy implements UpdateItemStrategy {
    @Override
    public void update(Item item) {
        updateSellIn(item);
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if (item.sellIn == 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
