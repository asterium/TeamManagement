package org.dimazay.tkgteammanagement.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by Asterium on 13.06.2017.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration{
    @Override
    protected String getDatabaseName() {
        return "teamManagement";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
}
