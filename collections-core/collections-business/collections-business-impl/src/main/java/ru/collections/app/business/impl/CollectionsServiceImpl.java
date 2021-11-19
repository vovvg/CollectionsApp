package ru.collections.app.business.impl;

import ru.collections.app.business.api.Collection;
import ru.collections.app.business.api.CollectionsService;
import ru.collections.app.domain.api.FirebaseService;

public class CollectionsServiceImpl implements CollectionsService {

    FirebaseService firebaseService;

    @Override
    public void create(String user, Integer amount, String name) {


        Collection collection = new Collection();

        collection.setName(name);
        for (int i = 1; i <= amount; i++)
            collection.setCards(String.valueOf(i), 0);

        firebaseService.create(user, collection.getCards(), collection.getName());
    }

    @Override
    public void save(Integer integer) {

    }
}
