package com.gildedrose;

import com.gildedrose.strategy.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            StrategyResolver resolver = new StrategyResolver();
            UpdateItemStrategy updateStrategy = resolver.resolve(item);
            updateStrategy.update(item);
        }
    }
}
