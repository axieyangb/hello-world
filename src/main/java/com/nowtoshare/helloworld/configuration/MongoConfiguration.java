package com.nowtoshare.helloworld.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;

@Configuration
public class MongoConfiguration {

    @Value("${MONGO_DB_USER}")
    private String mongoUser;

    @Value("${MONGO_DB_PASSWORD}")
    private String mongoPass;

    @Value("${MONGO_DB_NAME}")
    private String databaseName;

    private final String mongoPort ="27017";
    @Value("${MONGO_DB_ADDRESS}")
    private String mongoHost;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        // Set credentials
        MongoCredential credential = MongoCredential.createCredential(mongoUser, databaseName, mongoPass.toCharArray());
        ServerAddress serverAddress = new ServerAddress(mongoHost, Integer.parseInt(mongoPort));

        // Mongo Client
        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));

        // Mongo DB Factory
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
                mongoClient, databaseName);

        return simpleMongoDbFactory;
    }

    /**
     * Template ready to use to operate on the database
     *
     * @return Mongo Template ready to use
     */
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}
