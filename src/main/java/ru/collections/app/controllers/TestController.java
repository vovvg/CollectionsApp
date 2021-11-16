package ru.collections.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.collections.app.entities.Collection;
import ru.collections.app.service.FirebaseService;


@RestController
public class TestController {

    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/test")
    public String postExample() {

        FirebaseService firebaseService = new FirebaseService();
        Collection collection = new Collection("DONALD DUCK");
        collection.createCollection(128);
        collection.setCards(""+1, 2);

        firebaseService.saveData(collection);

        collection.setCards(""+4, 2);
        firebaseService.saveData(collection);
        Map<String, Integer> map = collection.getCards();
        Set<String> keys = map.keySet();

        List<Integer> values = new ArrayList<>(map.values());

        System.out.println("Значения: " + values);

        return collection.getName();
    }


}