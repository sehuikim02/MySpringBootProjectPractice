package com.rookies4.myspringbootlab.repository;

import com.rookies4.myspringbootlab.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // ISBN으로 조회
    Optional<Book> findByIsbn(String isbn);

    // ID로 Book + BookDetail 같이 조회
    @Query("SELECT b FROM Book b JOIN FETCH b.bookDetail WHERE b.id = :id")
    Optional<Book> findByIdWithBookDetail(@Param("id") Long id);

    // 저자명(대소문자 구분 없이 포함 검색)
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // 제목 검색 (추가로 활용 가능)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // ISBN 중복 여부 확인
    boolean existsByIsbn(String isbn);

    // 저자명으로 조회
    List<Book> findByAuthor(String author);
}