package ru.collections.app.domain.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import ru.collections.app.domain.api.FirebaseService;

import java.util.HashMap;


public class FirebaseServiceImpl implements FirebaseService {

    private Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public void create(String user, HashMap<String, Integer> cards, String name) {

        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(user).document(name).set(cards);
    }

    @Override
    public void save() {

    }
}
