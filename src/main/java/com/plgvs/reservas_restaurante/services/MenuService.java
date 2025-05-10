package com.plgvs.reservas_restaurante.services;

import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.IndexOptions;
import com.plgvs.reservas_restaurante.entities.Category;
import com.mongodb.client.model.Indexes;
import com.plgvs.reservas_restaurante.entities.Dish;
import jakarta.persistence.Index;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Service
public class MenuService {

    String uri = "mongodb://localhost:27017/";
    CodecRegistry pojoCodedRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build())
    );

    MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(uri))
                    .codecRegistry(pojoCodedRegistry)
                    .build()
    );

    MongoDatabase database = mongoClient.getDatabase("RestaurantMenu").withCodecRegistry(pojoCodedRegistry);
    MongoCollection<Category> collection = database.getCollection("Menu", Category.class);

    public void addCategory(Category category){
        Bson index = Indexes.ascending("categoryName");
        IndexOptions options = new IndexOptions().unique(true);
        collection.createIndex(index, options);
        collection.insertOne(category);
    }

    public void addDish(String categoryName, Dish dish){
        Category category = collection.find(eq("categoryName", categoryName)).first();

        if (category != null){
            category.getDishes().add(dish);
            collection.replaceOne(eq("categoryName", categoryName), category);
        }
        else {
            System.out.println("Not Found");
        }
    }

    public List<String> getDishes(String categoryName){
        Category category = collection.find(eq("categoryName", categoryName)).first();
        List<Dish> dishes = category.getDishes();
        List<String> teste = new ArrayList<>();

        Gson gson = new Gson();

        for (Dish d : dishes){
            System.out.println(d.getPrice());
            teste.add(gson.toJson(d));
        }

        return teste;
    }
}
