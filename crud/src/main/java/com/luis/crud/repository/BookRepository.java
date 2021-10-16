package com.luis.crud.repository;

import com.luis.crud.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
	/*@Modifying
	@Query("delete from books where id = ?1")
	void delete(Long entityId);*/
    
}

