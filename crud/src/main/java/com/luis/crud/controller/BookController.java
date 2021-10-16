package com.luis.crud.controller;

import com.luis.crud.entity.BookEntity;
import com.luis.crud.entity.dto.BookDTO;
import com.luis.crud.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public List<BookEntity> findAll() {
        
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookEntity findById(@PathVariable Long id) {
        BookEntity book = bookService.findById(id);
        System.out.println(book);
        return book;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity save(@RequestBody BookDTO bookDTO){
        return bookService.save(bookDTO);
    }
    
    @PutMapping("/{id}")
    public BookEntity update(@RequestBody BookDTO bookDTO, @PathVariable Long id){
        BookEntity bookEntity = bookService.findById(id);
        return bookService.update(bookEntity, bookDTO);
    }
    
    @DeleteMapping("/{id}")
    public void delete(Long id) {
    	bookService.delete(id);
    }
            
}
