package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.strategy.Util.updateSellIn;

public class UpdateAgedBrieItemStrategy implements UpdateItemStrategy {


    @Override
    public void update(Item item) {
        updateSellIn(item);
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn == 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
