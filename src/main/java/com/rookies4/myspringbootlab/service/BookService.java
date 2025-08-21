package com.rookies4.myspringbootlab.service;

import com.rookies4.myspringbootlab.controller.dto.BookDTO;
import com.rookies4.myspringbootlab.entity.Book;
import com.rookies4.myspringbootlab.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    // 도서 등록
    public BookDTO.BookResponse createBook(BookDTO.BookCreateRequest request) {
        Book book = request.toEntity();
        Book saved = bookRepository.save(book);
        return BookDTO.BookResponse.from(saved);
    }

    // 도서 수정
    public BookDTO.BookResponse updateBook(Long id, BookDTO.BookUpdateRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("도서를 찾을 수 없습니다."));

        book.setPrice(request.getPrice());
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishDate(request.getPublishDate());

        return BookDTO.BookResponse.from(book);
    }

    // 도서 삭제
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("도서를 찾을 수 없습니다.");
        }
        bookRepository.deleteById(id);
    }

    // 도서 단건 조회
    public BookDTO.BookResponse getBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("도서를 찾을 수 없습니다."));
        return BookDTO.BookResponse.from(book);
    }

    // 전체 도서 조회
    public List<BookDTO.BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookDTO.BookResponse::from)
                .toList();
    }
}
