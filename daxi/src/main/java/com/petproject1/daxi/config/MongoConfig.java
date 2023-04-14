package com.petproject1.daxi.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories(basePackages = "com.petproject1.daxi.repository")
public class MongoConfig {

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/daxi");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "daxi");
    }

//    @Override
//    protected String getDatabaseName() {
//        return "daxi";
//    }
//
//    @Override
//    protected void configureClientSettings(MongoClientSettings.Builder builder) {
//        builder.credential(MongoCredential.createCredential("root",
//                        "admin", "admin".toCharArray()))
//                .applyToClusterSettings(settings -> {
//                    settings.hosts((singletonList(
//                            new ServerAddress("127.0.0.1", 27017)
//                    )));
//                });
//    }
}