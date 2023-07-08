package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    @Test
    public void testAdd(){
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Harry Potter", 10, "JKRowling");
        Book book2 = new Book(2, "Game of thrones", 11, "JRRMartin");
        Book book3 = new Book(3, "Solaris", 13, "SLem");
        Smartphone phone1 = new Smartphone(4, "Samsung A54", 50, "Samsung");
        Smartphone phone2 = new Smartphone(5, "iPhone 13", 60, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);

        Product [] actual = repo.findAll();
        Product [] expected = {book1, book2, book3, phone1, phone2};

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testRemoveIdExist(){
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Harry Potter", 10, "JKRowling");
        Book book2 = new Book(2, "Game of thrones", 11, "JRRMartin");
        Book book3 = new Book(3, "Solaris", 13, "SLem");
        Smartphone phone1 = new Smartphone(4, "Samsung A54", 50, "Samsung");
        Smartphone phone2 = new Smartphone(5, "iPhone 13", 60, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        repo.removeById(1);

        Product [] actual = repo.findAll();
        Product [] expected = {book2, book3, phone1, phone2};

        Assertions.assertArrayEquals(expected,actual);
    }
}
