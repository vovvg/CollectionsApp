package ru.collections.app.entities;

import java.util.HashMap;
import java.util.Map;

public class Collection {

    private int id;
    private Map<Integer, Integer> cards = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Integer> getCards() {
        return cards;
    }

    public void setCards(Integer card, Integer amount) {
        this.cards.put(card, amount);
    }
}
