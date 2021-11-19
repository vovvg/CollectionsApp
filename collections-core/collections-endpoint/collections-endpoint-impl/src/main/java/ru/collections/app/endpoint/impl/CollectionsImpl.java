package ru.collections.app.endpoint.impl;

import ru.collections.app.business.api.CollectionsService;
import ru.collections.app.endpoint.api.Collections;

public class CollectionsImpl implements Collections {

    CollectionsService collectionsService;

    @Override
    public void create(String user, Integer amount, String name) {
        collectionsService.create(user, amount, name);
    }

    @Override
    public void save(Integer integer) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void get() {

    }
}
