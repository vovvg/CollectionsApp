package ru.collections.app.Service;

import ru.collections.app.Entity.Collection;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface CollectionService {
    String sortByAmount(Collection collection, Integer i);
    void add(String user, Collection collection);
    void create(String user, String name, Integer amountNumeric, String prefix, Integer amountAlphabetic);
    void create(String user, String name, Integer amountNumeric);
    ArrayList<Collection> getAllCollections(String user) throws ExecutionException, InterruptedException;
    Collection getCollection(String user, String name) throws ExecutionException, InterruptedException;
}
