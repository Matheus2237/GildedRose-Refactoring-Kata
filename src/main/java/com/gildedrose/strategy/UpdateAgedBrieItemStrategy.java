package com.gildedrose.strategy;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class UpdateAgedBrieItemStrategy implements UpdateItemStrategy {

    public void updateQuality(Item item) {
        item.quality = item.sellIn == 0
                ? min(50, item.quality + 2)
                : min(50, item.quality + 1);
    }
}
