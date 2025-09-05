package com.gildedrose.strategy;

import com.gildedrose.Item;

@Deprecated
public class Util {

    public static void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
    }
}
