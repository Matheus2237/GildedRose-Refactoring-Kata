@allure.label.owner:Matheus
@allure.label.epic:GildedRose
@allure.label.feature:InventoryManagement
Feature: Gilded Rose Inventory Management
  As a tavern keeper managing a magical inventory
  I want the quality of items to change according to their nature and time
  So that I can uphold the legendary reputation of the Gilded Rose

#  Background:
#    Given An inventory system managing item quality and sellIn

  Rule: Normal items
    - Quality decreases by 1 each day
    - Once sellIn reaches 0, quality decreases by 2 per day
    - Quality never goes below 0

  Rule: Special items
    - Aged Brie increases in quality as it gets older (max 50)
    - Backstage passes increase in quality, but drop to 0 after the concert
    - Sulfuras never changes in quality or sellIn
    - Conjured items degrade in quality twice as fast as normal items

    @critical
    Scenario Outline: Item quality and sellIn update correctly
      Given The item is "<NAME>" with sellIn <SELL_IN> and quality <QUALITY>
      When I update the quality
      Then The item should have sellIn <EXPECTED_SELL_IN> and quality <EXPECTED_QUALITY>

      Examples:
        | NAME                                      | SELL_IN | QUALITY | EXPECTED_SELL_IN  | EXPECTED_QUALITY  |

      # Normal items
        | +5 Dexterity Vest                         | 10      | 20      | 9                 | 19                |
        | +5 Dexterity Vest                         | 0       | 4       | 0                 | 2                 |
        | Elixir of the Mongoose                    | 5       | 7       | 4                 | 6                 |
        | Elixir of the Mongoose                    | 1       | 3       | 0                 | 2                 |

      # Aged Brie
        | Aged Brie                                 | 5       | 10      | 4                 | 11                |
        | Aged Brie                                 | 1       | 48      | 0                 | 49                |
        | Aged Brie                                 | 1       | 49      | 0                 | 50                |
        | Aged Brie                                 | 2       | 50      | 1                 | 50                |
        | Aged Brie                                 | 10      | 25      | 9                 | 26                |

      # Backstage passes
        | Backstage passes to a TAFKAL80ETC concert | 15      | 20      | 14                | 21                |
        | Backstage passes to a TAFKAL80ETC concert | 11      | 30      | 10                | 31                |
        | Backstage passes to a TAFKAL80ETC concert | 10      | 25      | 9                 | 27                |
        | Backstage passes to a TAFKAL80ETC concert | 5       | 25      | 4                 | 28                |
        | Backstage passes to a TAFKAL80ETC concert | 1       | 40      | 0                 | 43                |
        | Backstage passes to a TAFKAL80ETC concert | 0       | 25      | 0                 | 0                 |

      # Conjured items
        | Conjured Mana Cake                        | 3       | 6       | 2                 | 4                 |
        | Conjured Mana Cake                        | 2       | 8       | 1                 | 6                 |
        | Conjured Mana Cake                        | 1       | 5       | 0                 | 3                 |
        | Conjured Mana Cake                        | 0       | 6       | 0                 | 2                 |
