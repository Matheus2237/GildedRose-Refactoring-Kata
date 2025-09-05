package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.strategy.Util.updateSellIn;

public class UpdateSulfurasItemStrategy implements UpdateItemStrategy {

    @Override
    public void update(Item item) {
        updateSellIn(item);
    }
}
