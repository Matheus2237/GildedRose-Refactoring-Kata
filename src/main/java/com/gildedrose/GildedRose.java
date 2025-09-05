package com.gildedrose;

import com.gildedrose.strategy.*;

class GildedRose {

    private final Item[] items;
    private final StrategyResolver resolver;

    public GildedRose(Item[] items) {
        this.items = items;
        this.resolver = StrategyResolver.getInstance();
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateItemStrategy updateStrategy = resolver.resolve(item);
            updateStrategy.update(item);
        }
    }
}
