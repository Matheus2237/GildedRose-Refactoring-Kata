package com.gildedrose.strategy;

import com.gildedrose.Item;

public class UpdatePassessItemStrategy implements UpdateItemStrategy {

    @Override
    public void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    private void updateQuality(Item item) {
        item.quality++;

        if (item.sellIn < 11) {
            item.quality++;
        }

        if (item.sellIn < 6) {
            item.quality++;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }

        if (item.sellIn == 0) {
            item.quality = 0;
        }
    }
}
