package com.rith.bookmanagement.controllers;
import com.rith.bookmanagement.models.Book;
import com.rith.bookmanagement.services.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Service
public class BookController {
    BookService bs = new BookService();
    @GetMapping("/list")
    public ArrayList<Book> getAllBooks(){
        return bs.getAllBooks();
    }
    @GetMapping("/get_by_id")
    public Book getBookById(@RequestParam int id){
        return bs.getBookById(id);
    }
    @GetMapping("/year_equal")
    public ArrayList<Book> getYearEqual(@RequestParam String year){
        return bs.getYear(year, "equal");
    }
    @GetMapping("/year_smaller")
    public ArrayList<Book> getYearSmaller(@RequestParam String year){
        return bs.getYear(year, "small");
    }
    @GetMapping("/year_bigger")
    public ArrayList<Book> getYearBigger(@RequestParam String year){
        return bs.getYear(year, "big");
    }
    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
        bs.addBook(book);
    }
    @PutMapping("/update")
    public void updateBook(@RequestParam int id, @RequestBody Book book){
        bs.updateBook(id, book);
    }
}
