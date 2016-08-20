package com.maxim.jms.adapter;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by lede on 8/19/16.
 */
public class ConsumerAdapter {
    private static Logger logger = LogManager.getLogger(ConsumerAdapter.class.getName());
    public void sendToMongo(String json) {
        logger.info("Sending to MongoDB");
        MongoClient client = new MongoClient();
        DB db = client.getDB("vendor");
        db.getCollection("contact");

        DBCollection collection = db.getCollection("contact");
        logger.info("Coverting JSON to DBObject");
        DBObject object = (DBObject) JSON.parse(json);
        collection.insert(object);
        logger.info("Sent to MongoDB");
    }
}
