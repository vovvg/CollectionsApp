package ru.collections.app.domain.api;

import java.util.HashMap;

public interface FirebaseService {
    void create(String user, HashMap<String, Integer> cards, String name);
    void save();
}
