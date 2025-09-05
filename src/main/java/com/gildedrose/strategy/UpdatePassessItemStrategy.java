package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.strategy.Util.updateSellIn;

public class UpdatePassessItemStrategy implements UpdateItemStrategy {

    @Override
    public void update(Item item) {
        updateSellIn(item);


        item.quality = item.quality + 1;
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn == 0) {
                item.quality = item.quality - item.quality;
            }
        }
    }
}
