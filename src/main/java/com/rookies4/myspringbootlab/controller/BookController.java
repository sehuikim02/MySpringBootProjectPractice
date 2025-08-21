package com.rookies4.myspringbootlab.controller;

import com.rookies4.myspringbootlab.controller.dto.BookDTO;
import com.rookies4.myspringbootlab.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 도서 등록
    @PostMapping
    public ResponseEntity<BookDTO.BookResponse> createBook(
            @Valid @RequestBody BookDTO.BookCreateRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    // 도서 수정
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO.BookResponse> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookDTO.BookUpdateRequest request) {
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    // 도서 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // 도서 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO.BookResponse> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    // 전체 도서 조회
    @GetMapping
    public ResponseEntity<List<BookDTO.BookResponse>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
