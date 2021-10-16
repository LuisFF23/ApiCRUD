package com.luis.crud.service;

import com.luis.crud.entity.BookEntity;
import com.luis.crud.entity.dto.BookDTO;
import com.luis.crud.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> findAll() {
        
        return bookRepository.findAll();
    }

    public BookEntity findById(Long id) {
        
        BookEntity entity =  bookRepository.getById(id);
        if (entity==null){
            return null;
        }else{
            return entity;
        }
    }

    public BookEntity save(BookDTO bookDTO) {
        
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAno(bookDTO.getAno());
        bookEntity.setAutor(bookDTO.getAutor());
        bookEntity.setNome(bookDTO.getNome());
        
        return bookRepository.save(bookEntity);
    }

    public BookEntity update(BookEntity bookEntity, BookDTO bookDTO) {
        bookEntity.setAno(bookDTO.getAno());
        bookEntity.setAutor(bookDTO.getAutor());
        bookEntity.setNome(bookDTO.toString());
        return bookRepository.save(bookEntity);
    }
    
    public void delete(Long id) {
        bookRepository.delete(id);
    }
    
}
