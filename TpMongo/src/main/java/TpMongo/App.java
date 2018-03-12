package TpMongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws UnknownHostException {

        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();
        morphia.map(Person.class).map(Address.class);
        Datastore ds = morphia.createDatastore(mongo, "TpMongo");


        Person pers1 = new Person("Alex");
        Address addr1 = new Address("Rue de Chateaugiron", "France", "35000", "Rennes");
        pers1.setAddress(addr1);

        Person pers2 = new Person("Mino");
        Address addr2 = new Address("Rue Principale", "France", "35410", "Domloup");
        pers2.setAddress(addr2);

        Person pers3 = new Person("Marc");
        Address addr3 = new Address("Rue du Général de Gaule", "France", "35000", "Rennes");
        pers3.setAddress(addr3);

        // Save the POJO
        ds.save(pers1);
        ds.save(pers2);
        ds.save(pers3);

        for (Person e : ds.find(Person.class))
            System.err.println(e);



    }
}
