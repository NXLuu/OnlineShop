/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Book implements Serializable{
    private String ISBN;
    private String title;
    private String summary;
    private Date publicationDate;
    private int numberOfPages;
    private String language;
    private String size;
    private ArrayList<Translator> translator;
    private Supplier supplier;
    private Publisher publisher;
    private ArrayList<Category> category;
    private ArrayList<Author> author;

    
    
    public Book() {
        super();
    }

    public Book(String ISBN, String title, String summary, Date publicationDate, int numberOfPages, String language, String size, ArrayList<Translator> translator, Supplier supplier, Publisher publisher, ArrayList<Category> category, ArrayList<Author> author) {
        this.ISBN = ISBN;
        this.title = title;
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.size = size;
        this.translator = translator;
        this.supplier = supplier;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<Translator> getTranslator() {
        return translator;
    }

    public void setTranslator(ArrayList<Translator> translator) {
        this.translator = translator;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public ArrayList<Category> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Category> category) {
        this.category = category;
    }

    public ArrayList<Author> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }
    
}
