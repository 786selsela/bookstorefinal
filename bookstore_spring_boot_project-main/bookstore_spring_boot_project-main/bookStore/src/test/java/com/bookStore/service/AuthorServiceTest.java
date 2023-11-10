package com.bookStore.service;

import com.bookStore.entity.Author;
import com.bookStore.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository mockAuthorRepository;

    @InjectMocks
    private AuthorService authorServiceUnderTest;

    @Test
    void testGetAllAuthors () {
        // Setup
        // Configure AuthorRepository.findAll(...).
        final Author author = new Author();
        author.setId(0L);
        author.setName("name");
        author.setBio("bio");
        final List<Author> authors = List.of(author);
        when(mockAuthorRepository.findAll()).thenReturn(authors);

        // Run the test
        final List<Author> result = authorServiceUnderTest.getAllAuthors();

        // Verify the results
    }

    @Test
    void testGetAllAuthors_AuthorRepositoryReturnsNoItems () {
        // Setup
        when(mockAuthorRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Author> result = authorServiceUnderTest.getAllAuthors();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetAuthorById () {
        // Setup
        // Configure AuthorRepository.findById(...).
        final Author author1 = new Author();
        author1.setId(0L);
        author1.setName("name");
        author1.setBio("bio");
        final Optional<Author> author = Optional.of(author1);
        when(mockAuthorRepository.findById(0L)).thenReturn(author);

        // Run the test
        final Author result = authorServiceUnderTest.getAuthorById(0L);

        // Verify the results
    }

    @Test
    void testGetAuthorById_AuthorRepositoryReturnsAbsent () {
        // Setup
        when(mockAuthorRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Author result = authorServiceUnderTest.getAuthorById(0L);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testSaveAuthor () {
        // Setup
        final Author author = new Author();
        author.setId(0L);
        author.setName("name");
        author.setBio("bio");

        // Configure AuthorRepository.save(...).
        final Author author1 = new Author();
        author1.setId(0L);
        author1.setName("name");
        author1.setBio("bio");
        when(mockAuthorRepository.save(any(Author.class))).thenReturn(author1);

        // Run the test
        final Author result = authorServiceUnderTest.saveAuthor(author);

        // Verify the results
    }

    @Test
    void testDeleteAuthor () {
        // Setup
        // Run the test
        authorServiceUnderTest.deleteAuthor(0L);

        // Verify the results
        verify(mockAuthorRepository).deleteById(0L);
    }
}
