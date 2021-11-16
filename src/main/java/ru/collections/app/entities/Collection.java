package ru.collections.app.entities;

import java.util.HashMap;
import java.util.Map;

public class Collection {

    private String name;
    private Map<String, Integer> cards = new HashMap<>();

    public void createCollection(Integer amount) {
        for (int i = 1; i <= amount; i++)
            this.cards.put(""+i, 0);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getCards() {
        return cards;
    }

    public void setCards(String card, Integer amount) {
        this.cards.put(card, amount);
    }

    public Collection(String name) {
        this.name = name;
    }
    public Collection() {
    }
}
