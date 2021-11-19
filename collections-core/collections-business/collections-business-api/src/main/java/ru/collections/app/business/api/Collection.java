package ru.collections.app.business.api;

import java.util.HashMap;

public class Collection {

    private String user;
    private String name;
    private HashMap<String, Integer> cards = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getCards() {
        return cards;
    }

    public void setCards(String card, Integer amount) {
        this.cards.put(card, amount);
    }


}
