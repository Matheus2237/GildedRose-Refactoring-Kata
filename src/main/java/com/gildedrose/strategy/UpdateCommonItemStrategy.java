package com.gildedrose.strategy;

import com.gildedrose.Item;

import static java.lang.Math.max;

public class UpdateCommonItemStrategy implements UpdateItemStrategy {

    public void updateQuality(Item item) {
        item.quality = item.sellIn == 0
                ? max(0, item.quality - 2)
                : max(0, item.quality - 1);
    }
}
