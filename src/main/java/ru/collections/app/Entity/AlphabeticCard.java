package ru.collections.app.Entity;

import java.util.HashMap;

public class AlphabeticCard {
    private HashMap<String, Integer> cards;
    private String prefix;

    public HashMap<String, Integer> getCards() {
        return cards;
    }

    public void setCards(HashMap<String, Integer> cards) {
        this.cards = cards;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
