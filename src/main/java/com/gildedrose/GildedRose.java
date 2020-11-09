package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * change quality and sellIn values of Item object
     * 
     * @param item : the item to change
     * @param itemQualityAdd : the number to add to quality
     * @param maxQualityValue : the number the quality must not exceed
    */
    private void changeItem(Item item, int itemQualityAdd, int maxQualityValue) {
        item.sellIn -= 1;
        item.quality += itemQualityAdd;
        if (item.quality < 0)
            item.quality = 0;
        if (item.quality > maxQualityValue)
            item.quality = maxQualityValue;
    }


/*      public void updateQuality() { for (int i = 0; i < items.length; i++) { if
      (!items[i].name.equals("Aged Brie") &&
      !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { if
      (items[i].quality > 0) { if
      (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { items[i].quality =
      items[i].quality - 1; } } } else { if (items[i].quality < 50) {
      items[i].quality = items[i].quality + 1;
      
      if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { if
      (items[i].sellIn < 11) { if (items[i].quality < 50) { items[i].quality =
      items[i].quality + 1; } }
      
      if (items[i].sellIn < 6) { if (items[i].quality < 50) { items[i].quality =
      items[i].quality + 1; } } } } }
      
      if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { items[i].sellIn =
      items[i].sellIn - 1; }
      
      if (items[i].sellIn < 0) { if (!items[i].name.equals("Aged Brie")) { if
      (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { if
      (items[i].quality > 0) { if
      (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { items[i].quality =
      items[i].quality - 1; } } } else { items[i].quality = items[i].quality -
      items[i].quality; } } else { if (items[i].quality < 50) { items[i].quality =
      items[i].quality + 1; } } } } } */
     

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie"))
                this.changeItem(items[i], 1, 50);
            else if (items[i].name.equals("Sulfuras"))
                this.changeItem(items[i], 0, 80);
            else if (items[i].name.equals("Conjured"))
                this.changeItem(items[i], -2, 50);
            else if (items[i].name.equals("Backstage passes")) {
                if (items[i].sellIn <= 5)
                    this.changeItem(items[i], 3, 50);
                else if (items[i].sellIn <= 10)
                    this.changeItem(items[i], 2, 50);
                else
                    this.changeItem(items[i], 1, 50);
            }
            else
            {
                if (items[i].sellIn <= 0)
                this.changeItem(items[i], -2, 50);
                else
                this.changeItem(items[i], -1, 50);
            }
        }
    }
}