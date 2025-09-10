package com.gildedrose.strategy;

import com.gildedrose.Item;

import static java.lang.Math.max;

public class UpdateConjuredItemStrategy implements UpdateItemStrategy {

    public void updateQuality(Item item) {
        item.quality = item.sellIn == 0
            ? max(0, item.quality - 4)
            : max(0, item.quality - 2);
    }
}
