package com.gildedrose.strategy;

import com.gildedrose.Item;

public class UpdateSulfurasItemStrategy implements UpdateItemStrategy {

    @Override
    public void update(Item item) {
        updateSellIn(item);
    }
}
