package com.bookStore.service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository mockBRepo;

    @InjectMocks
    private BookService bookServiceUnderTest;

    @Test
    void testSave () {
        // Setup
        final Book b = new Book(0, "name", "author", "price");

        // Run the test
        bookServiceUnderTest.save(b);

        // Verify the results
        verify(mockBRepo).save(any(Book.class));
    }

    @Test
    void testGetAllBook () {
        // Setup
        // Configure BookRepository.findAll(...).
        final List<Book> books = List.of(new Book(0, "name", "author", "price"));
        when(mockBRepo.findAll()).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.getAllBook();

        // Verify the results
    }

    @Test
    void testGetAllBook_BookRepositoryReturnsNoItems () {
        // Setup
        when(mockBRepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Book> result = bookServiceUnderTest.getAllBook();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetBookById () {
        // Setup
        // Configure BookRepository.findById(...).
        final Optional<Book> book = Optional.of(new Book(0, "name", "author", "price"));
        when(mockBRepo.findById(0)).thenReturn(book);

        // Run the test
        final Book result = bookServiceUnderTest.getBookById(0);

        // Verify the results
    }

    @Test
    void testGetBookById_BookRepositoryReturnsAbsent () {
        // Setup
        when(mockBRepo.findById(0)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> bookServiceUnderTest.getBookById(0)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void testDeleteById () {
        // Setup
        // Run the test
        bookServiceUnderTest.deleteById(0);

        // Verify the results
        verify(mockBRepo).deleteById(0);
    }
}
