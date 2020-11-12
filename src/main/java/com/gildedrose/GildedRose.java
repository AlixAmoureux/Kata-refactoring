package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * change quality and sellIn values of Item object
     * 
     * @param item            : the item to change
     * @param itemQualityAdd  : the number to add to quality
     * @param maxQualityValue : the number the quality must not exceed
     */
    private void changeItem(Item item, int itemQualityAdd, int maxQualityValue) {
        if (maxQualityValue != 80) {
            item.sellIn -= 1;
            item.quality += itemQualityAdd;
            if (item.quality < 0)
                item.quality = 0;
            if (item.quality > maxQualityValue)
                item.quality = maxQualityValue;
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(ItemName.AGED_BRIE))
                this.changeItem(items[i], 1, 50);
            else if (items[i].name.equals(ItemName.SULFURAS))
                this.changeItem(items[i], 0, 80);
            else if (items[i].name.equals(ItemName.CONJURED))
                this.changeItem(items[i], -2, 50);
            else if (items[i].name.equals(ItemName.BACKSTAGE)) {
                if (items[i].sellIn <= 0) {
                    items[i].sellIn -= 1;
                    items[i].quality = 0;
                }
                if (items[i].sellIn <= 5)
                    this.changeItem(items[i], 3, 50);
                else if (items[i].sellIn <= 10)
                    this.changeItem(items[i], 2, 50);
                else
                    this.changeItem(items[i], 1, 50);
            } else {
                if (items[i].sellIn <= 0)
                    this.changeItem(items[i], -2, 50);
                else
                    this.changeItem(items[i], -1, 50);
            }
        }
    }
}