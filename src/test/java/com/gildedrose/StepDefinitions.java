package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private final Item[] items = new Item[1];

    @Given("The item is {string} with sellIn {int} and quality {int}")
    @Step("Setting initial item: {0}, sellIn={1}, quality={2}")
    public void theItemIsWithSellInAndQuality(String name, Integer sellIn, Integer quality) {
        items[0] = new Item(name, sellIn, quality);
        Allure.parameter("Item Name", name);
        Allure.parameter("Sell In", sellIn);
        Allure.parameter("Quality", quality);
        attachItemState("Initial Item", items[0]);
    }

    @When("I update the quality")
    @Step("Updating item quality")
    public void iUpdateTheQuality() {
        GildedRose app = new GildedRose(items);
        Allure.step("State before update", () -> attachItemState("Before Update", items[0]));
        app.updateQuality();
        Allure.step("State after update", () -> attachItemState("After Update", items[0]));
    }

    @Then("The item should have sellIn {int} and quality {int}")
    @Step("Validating expected result: sellIn={0}, quality={1}")
    public void theItemShouldHaveSellInAndQuality(Integer expectedSellIn, Integer expectedQuality) {
        Allure.step("Comparing expected values", () -> {
            assertEquals(expectedSellIn.intValue(), items[0].sellIn, "SellIn does not match expected");
            assertEquals(expectedQuality.intValue(), items[0].quality, "Quality does not match expected");
        });
        attachItemState("Final Item", items[0]);
    }

    @Step("Attaching item state")
    private void attachItemState(String title, Item item) {
        String content = String.format("Name: %s%nSellIn: %d%nQuality: %d", item.name, item.sellIn, item.quality);
        Allure.addAttachment(title, "text/plain", content, ".txt");
    }
}
