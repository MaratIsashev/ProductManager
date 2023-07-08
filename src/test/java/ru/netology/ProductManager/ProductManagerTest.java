package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void testAdd(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 10, "JKRowling");
        Book book2 = new Book(2, "Game of thrones", 11, "JRRMartin");
        Book book3 = new Book(3, "Solaris", 13, "SLem");
        Smartphone phone1 = new Smartphone(4, "Samsung A54", 50, "Samsung");
        Smartphone phone2 = new Smartphone(5, "iPhone 13", 60, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);

        Product [] actual = repo.findAll();
        Product [] expected = {book1, book2, book3, phone1, phone2};

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testSearchWithSingleResult(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 10, "JKRowling");
        Book book2 = new Book(2, "Game of thrones", 11, "JRRMartin");
        Book book3 = new Book(3, "Solaris", 13, "SLem");
        Smartphone phone1 = new Smartphone(4, "Samsung A54", 50, "Samsung");
        Smartphone phone2 = new Smartphone(5, "iPhone 13", 60, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);

        Product [] actual = manager.searchBy("Game");
        Product [] expected = {book2};

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testSearchWithMultipleResult(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 10, "JKRowling");
        Book book2 = new Book(2, "Game of thrones", 11, "JRRMartin");
        Book book3 = new Book(3, "Solaris", 13, "SLem");
        Smartphone phone1 = new Smartphone(4, "Samsung A54", 50, "Samsung");
        Smartphone phone2 = new Smartphone(5, "iPhone 13", 60, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);

        Product [] actual = manager.searchBy("on");
        Product [] expected = {book2, phone2};

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testSearchWithNoResult(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 10, "JKRowling");
        Book book2 = new Book(2, "Game of thrones", 11, "JRRMartin");
        Book book3 = new Book(3, "Solaris", 13, "SLem");
        Smartphone phone1 = new Smartphone(4, "Samsung A54", 50, "Samsung");
        Smartphone phone2 = new Smartphone(5, "iPhone 13", 60, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);

        Product [] actual = manager.searchBy("Gaga");
        Product [] expected = {};

        Assertions.assertArrayEquals(expected,actual);
    }
}
