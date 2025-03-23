package ru.collections.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import ru.collections.app.Entity.AlphabeticCard;
import ru.collections.app.Entity.Collection;
import ru.collections.app.Repository.FirebaseService;
import ru.collections.app.Repository.FirebaseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class CollectionServiceImpl implements CollectionService {

    FirebaseService firebaseService = new FirebaseServiceImpl();

    @Override
    public String sortByAmount(Collection collection, Integer integer) {
        Integer uniq = 0;
        for (int i = 1; i <= collection.getNumeric().size(); i++) {
            if (collection.getNumeric().get(String.valueOf(i)) > integer)
                uniq++;
        }
        return String.valueOf(uniq);
    }

    @Override
    public String repeatCards(Collection collection) {
        Integer uniq = 0;
        for (int i = 1; i <= collection.getNumeric().size(); i++) {
            if (collection.getNumeric().get(String.valueOf(i)) > 1)
                uniq += collection.getNumeric().get(String.valueOf(i)) - 1;
        }
        return String.valueOf(uniq);
    }

    @Override
    public void add(String user, Collection collection) {
        firebaseService.addToCollection(user, collection);
    }

    @Override
    public void create(String user, String name, Integer amountNumeric, String prefix, Integer amountAlphabetic) {
        Collection collection = new Collection();
        HashMap<String, Integer> numericCards = new HashMap<>();
        for (int i = 1; i <= amountNumeric; i++)
            numericCards.put( String.valueOf(i),0);

        AlphabeticCard alphabetic = new AlphabeticCard();
        HashMap<String, Integer> alphabeticCards = new HashMap<>();
        for (int i = 1; i <= amountAlphabetic; i++)
            alphabeticCards.put( prefix + String.valueOf(i),0);
        alphabetic.setCards(alphabeticCards);
        alphabetic.setPrefix(prefix);

        collection.setCollectionName(name);
        collection.setNumeric(numericCards);
        collection.setAlphabetic(alphabetic);


        firebaseService.createCollections(user, collection);
    }

    @Override
    public void create(String user, String name, Integer amountNumeric) {
        Collection collection = new Collection();
        HashMap<String, Integer> newCollection = new HashMap<>();
        for (int i = 1; i <= amountNumeric; i++)
            newCollection.put( String.valueOf(i),0);
        collection.setCollectionName(name);
        collection.setNumeric(newCollection);

        firebaseService.createCollections(user, collection);
    }


    @Override
    public ArrayList<Collection> getAllCollections(String user) throws ExecutionException, InterruptedException {
        return firebaseService.getAllCollections(user);

    }

    @Override
    public Collection getCollection(String user, String name) throws ExecutionException, InterruptedException {
        return firebaseService.getCollection(user, name);
    }
}
