package com.gildedrose.strategy;

import com.gildedrose.Item;

public class UpdateCommonItemStrategy implements UpdateItemStrategy {
    @Override
    public void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    private void updateQuality(Item item) {
        item.quality--;
        if (item.sellIn == 0) {
            item.quality--;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
