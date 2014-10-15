package com.chartwithmongo.service;


import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.chartwithmongo.model.Fruit;

@Repository
public class MongoService {
@Autowired
private MongoTemplate mongoTemplate;

public static final String COLLECTION_NAME = "fruitCount"; //--------1)

public void addFruit(Fruit fruit){
	if(!mongoTemplate.collectionExists(Fruit.class)){
		mongoTemplate.createCollection(Fruit.class);
	}
	fruit.setId(UUID.randomUUID().toString());
	//fruit.setFrName();
	//fruit.setFrName();
	mongoTemplate.insert(fruit,COLLECTION_NAME);
}

public List<Fruit> listFruit(){
	return mongoTemplate.findAll(Fruit.class,COLLECTION_NAME);
}

/*
public void addBook(Book book) {
if (!mongoTemplate.collectionExists(Book.class)) {  //---------2)
mongoTemplate.createCollection(Book.class);
}                       
book.setId(UUID.randomUUID().toString());
mongoTemplate.insert(book, COLLECTION_NAME); //------3)
}

public List<Book> listBook() {
return mongoTemplate.findAll(Book.class, COLLECTION_NAME);
}*/


}
