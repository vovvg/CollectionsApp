package ru.collections.app.Repository;


import ru.collections.app.Entity.Collection;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface FirebaseService {
    ArrayList<Collection> getAllCollections(String user) throws ExecutionException, InterruptedException;
    Collection getCollection(String user, String name) throws ExecutionException, InterruptedException;
    void createCollections(String user, Collection collection);
    void addToCollection(String user, Collection collection);
}
