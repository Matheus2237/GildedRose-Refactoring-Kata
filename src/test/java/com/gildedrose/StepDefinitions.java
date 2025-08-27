package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private final Item[] items = new Item[1];

    @Given("The item is {string} with sellIn {int} and quality {int}")
    public void theItemIsWithSellInAndQuality(String name, Integer sellIn, Integer quality) {
        items[0] = new Item(name, sellIn, quality);
    }

    @When("I update the quality")
    public void iUpdateTheQuality() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }

    @Then("The item should have sellIn {int} and quality {int}")
    public void theItemShouldHaveSellInAndQuality(Integer sellIn, Integer quality) {
        assertEquals(sellIn.intValue(), items[0].sellIn);
        assertEquals(quality.intValue(), items[0].quality);
    }
}