package ru.collections.app.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import ru.collections.app.Entity.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirebaseServiceImpl implements FirebaseService {

    @Override
    public void createCollections(String user, Collection collection) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = dbFirestore.collection(user).document(collection.getCollectionName()).set(collection);
    }

    @Override
    public void addToCollection(String user, Collection collection) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = dbFirestore.collection(user).document(collection.getCollectionName()).set(collection);
    }

    @Override
    public ArrayList<Collection> getAllCollections(String user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference documentReference = dbFirestore.collection(user);
        ApiFuture<QuerySnapshot> future = documentReference.get();
        QuerySnapshot document = future.get();
        List<QueryDocumentSnapshot> list = document.getDocuments();
        ArrayList<Collection> collections = new ArrayList<>();

        for (QueryDocumentSnapshot e : list)
            collections.add(e.toObject(Collection.class));

        return collections;
    }

    @Override
    public Collection getCollection(String user, String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(user).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        return  document.toObject(Collection.class);
    }


}
