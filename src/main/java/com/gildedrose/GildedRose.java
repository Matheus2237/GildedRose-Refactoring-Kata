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

            if (items[i].name.equals("Conjured Mana Cake")) {
                new UpdateConjuredItemStrategy().update(items[i]);
            }

            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                new UpdateSulfurasItemStrategy().update(items[i]);
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                new UpdatePassessItemStrategy().update(items[i]);
            }

            if (items[i].name.equals("Aged Brie")) {
                new UpdateAgedBrieItemStrategy().update(items[i]);
            }

            if (!items[i].name.equals("Conjured Mana Cake")
                    && !items[i].name.equals("Sulfuras, Hand of Ragnaros")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Aged Brie")) {
                new UpdateCommonItemStrategy().update(items[i]);
            }
        }
    }
}
