package com.gildedrose;

import com.gildedrose.strategy.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // TODO: Enhance for
        for (int i = 0; i < items.length; i++) {
            StrategyResolver resolver = new StrategyResolver();
            UpdateItemStrategy updateStrategy = resolver.resolve(items[i]);
            updateStrategy.update(items[i]);
        }
    }
}
