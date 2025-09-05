package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // TODO: Enhance for
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals("Conjured Mana Cake")) {
                updateSellIn(items[i]);
                if (items[i].quality > 1) {
                    items[i].quality = items[i].quality - 2;
                } else {
                    items[i].quality = 0;
                }
            }

            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                updateSellIn(items[i]);
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateSellIn(items[i]);


                items[i].quality = items[i].quality + 1;
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }

                    if (items[i].sellIn < 6) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }

                    if (items[i].sellIn == 0) {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                }
            }

            if (items[i].name.equals("Aged Brie")) {
                updateSellIn(items[i]);
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
            }

            if (!items[i].name.equals("Conjured Mana Cake")
                    && !items[i].name.equals("Sulfuras, Hand of Ragnaros")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Aged Brie")) {
                updateSellIn(items[i]);
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                if (items[i].sellIn == 0) {
                    if (!items[i].name.equals("Aged Brie")) {
                        if (!items[i].name.equals("Conjured Mana Cake")) {
                            items[i].quality = items[i].quality - 1;
                        } else {
                            items[i].quality = items[i].quality - 2;
                        }
                        if (items[i].quality < 0) {
                            items[i].quality = 0;
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
    }
}
