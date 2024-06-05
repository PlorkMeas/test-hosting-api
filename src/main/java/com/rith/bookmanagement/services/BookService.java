package com.rith.bookmanagement.services;

import com.rith.bookmanagement.models.Book;
import java.util.ArrayList;
import java.util.Random;

public class BookService {
    private ArrayList<Book> books = null;

    public BookService(){
        books = new ArrayList<Book>();
        String[] titles = {"The Great Adventure", "Mystery of the Old House", "Journey to the West",
                "The Last Kingdom", "Science and Fiction", "History of the World",
                "The Future of AI", "Philosophy 101", "Advanced Mathematics", "Cooking with Love",
                "Art of War", "Digital Fortress", "Pride and Prejudice", "War and Peace",
                "The Catcher in the Rye", "To Kill a Mockingbird", "1984", "Brave New World",
                "The Hobbit", "The Lord of the Rings"};
        String[] authors = {"Alice Smith", "Bob Johnson", "Carol Williams", "David Brown",
                "Eve Davis", "Frank Miller", "Grace Wilson", "Hank Moore",
                "Ivy Taylor", "Jack Anderson", "Katie Brown", "Liam Nelson",
                "Mia Thompson", "Noah Clark", "Olivia White", "Peter Wright",
                "Quincy Adams", "Rachel Green", "Samuel Roberts", "Tina Turner"};
        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            String title = titles[i - 1];  // Directly using the i-th element for simplicity
            String author = authors[i - 1];  // Directly using the i-th element for simplicity
            String year = String.valueOf(1980 + random.nextInt(41));  // Random year between 1980 and 2020
            books.add(new Book(i, title, author, year));
        }
    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id){
        for(Book temp : books){
            if(temp.getId()==id) return temp;
        }
        return null;
    }

    public ArrayList<Book> getYear(String year, String action){
        ArrayList<Book> result = new ArrayList<>();
        for(Book temp : books){
            if(action.equalsIgnoreCase("equal")){
                if(temp.getYear().equalsIgnoreCase(year))
                    result.add(temp);
            }else if(action.equalsIgnoreCase("small")){
                if(temp.getYear().compareToIgnoreCase(year)<0)
                    result.add(temp);
            }else{
                if(temp.getYear().compareToIgnoreCase(year)>0)
                    result.add(temp);
            }
        }
        return result;
    }

    public boolean addBook(Book book){
        return books.add(book);
    }
    public boolean updateBook(int id, Book book){
        for(Book temp: books){
            if(temp.getId()==id){
                temp.setName(book.getName());
                temp.setYear(book.getYear());
                temp.setAuthor(book.getAuthor());
                return true;
            }
        }
        return false;
    }
    public boolean deleteBook(int id){
        for(Book temp: books){
            if(temp.getId()==id){
                return books.remove(temp);
            }
        }
        return false;
    }
}

