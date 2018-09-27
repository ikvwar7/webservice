package webservice.service;

import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Component
public class DBManagerService {
    private MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoDatabase database = mongoClient.getDatabase("ClientsInfo");


    public void insertClientInfo(HttpServletRequest htr) {
        MongoCollection<Document> mongoCollection = getCollection("clientsInfo");
        Document document = new Document();
        document.put("ip", htr.getRemoteAddr());
        document.put("time", LocalDateTime.now());
        document.put("browser", htr.getHeader("User-Agent"));
        //mongoCollection.deleteMany(eq("ip", htr.getRemoteAddr()));
        mongoCollection.insertOne(document);
    }

    public List<Document> getClientsInfo() {
        MongoCollection<Document> mongoCollection = getCollection("clientsInfo");
        FindIterable<Document> docs = mongoCollection.find();
        List<Document> list = new ArrayList<>();
        Iterator<Document> it = docs.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    private MongoCollection<Document> getCollection(String name) {
        MongoCollection<Document> mongoCollection;
        try {
            database.createCollection(name);
        } catch (MongoCommandException ignored) {
        } finally {
            mongoCollection = database.getCollection(name);
        }
        return mongoCollection;
    }
}
