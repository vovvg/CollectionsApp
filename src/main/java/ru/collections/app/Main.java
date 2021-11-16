package ru.collections.app;

import ru.collections.app.entities.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Collection collection = new Collection();
        collection.setCards(1, 2);
        collection.setCards(2, 1);

        Map<Integer, Integer> map = collection.getCards();
        Set<Integer> keys = map.keySet();

        List<Integer> values = new ArrayList<>(map.values());

        System.out.println(map.get(1));
        System.out.println("Значения: " + values);

    }
}
