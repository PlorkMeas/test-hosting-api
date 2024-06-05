package com.rith.bookmanagement.controllers;
import com.rith.bookmanagement.models.Book;
import com.rith.bookmanagement.services.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Service
public class BookController {
    BookService bc = new BookService();
    @GetMapping("/list")
    public ArrayList<Book> getAllBooks(){
        return bc.getAllBooks();
    }
    @GetMapping("/get_by_id")
    public Book getBookById(@RequestParam int id){
        return bc.getBookById(id);
    }
    @GetMapping("/year_equal")
    public ArrayList<Book> getYearEqual(@RequestParam String year){
        return bc.getYearEqual(year);
    }
    @GetMapping("/year_smaller")
    public ArrayList<Book> getYearSmaller(@RequestParam String year){
        return bc.getYearSmaller(year);
    }
    @GetMapping("/year_bigger")
    public ArrayList<Book> getYearBigger(@RequestParam String year){
        return bc.getYearBigger(year);
    }
}
