package com.rookies4.myspringbootlab.repository;

import com.rookies4.myspringbootlab.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {

    // BookId로 BookDetail 조회
    Optional<BookDetail> findByBookId(Long bookId);

    // BookDetail + Book 같이 조회
    @Query("SELECT bd FROM BookDetail bd JOIN FETCH bd.book WHERE bd.id = :id")
    Optional<BookDetail> findByIdWithBook(@Param("id") Long id);

    // 출판사로 조회
    List<BookDetail> findByPublisher(String publisher);
}
