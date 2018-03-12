package TpMongo;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

public class Article {

    @Id
    private ObjectId id;
    private String name;
    private int stars;
    @Embedded
    private Person person;

    public Article() {
        super();
    }

    public Article(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Article(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
