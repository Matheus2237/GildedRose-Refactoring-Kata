package com.gildedrose.strategy;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class UpdatePassessItemStrategy implements UpdateItemStrategy {

    public void updateQuality(Item item) {
        if (item.sellIn == 0) {
            item.quality = 0;
            return;
        }

        int increment = 1;
        if (item.sellIn < 11) increment++;
        if (item.sellIn < 6) increment++;

        item.quality = min(50, item.quality + increment);
    }
}
