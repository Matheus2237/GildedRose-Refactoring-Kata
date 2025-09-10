package com.gildedrose.strategy;

import com.gildedrose.Item;

public class UpdateSulfurasItemStrategy implements UpdateItemStrategy {

    @Override
    public void updateQuality(Item item) {
        /// Empty because Sulfuras never changes its quality
    }
}
