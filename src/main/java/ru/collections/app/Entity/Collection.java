package ru.collections.app.Entity;

import java.util.HashMap;

public class Collection {
    private String CollectionName;
    private HashMap<String, Integer> numeric;
    private AlphabeticCard alphabetic;


    public Collection() {
    }


    public String getCollectionName() {
        return CollectionName;
    }

    public void setCollectionName(String collectionName) {
        this.CollectionName = collectionName;
    }

    public HashMap<String, Integer> getNumeric() {
        return numeric;
    }

    public void setNumeric(HashMap<String, Integer> numeric) {
        this.numeric = numeric;
    }

    public AlphabeticCard getAlphabetic() {
        return alphabetic;
    }

    public void setAlphabetic(AlphabeticCard alphabetic) {
        this.alphabetic = alphabetic;
    }
}
