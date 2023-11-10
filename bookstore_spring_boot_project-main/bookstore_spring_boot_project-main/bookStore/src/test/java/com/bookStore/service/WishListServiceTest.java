package com.bookStore.service;

import com.bookStore.entity.WishList;
import com.bookStore.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WishListServiceTest {

    @Mock
    private WishListRepository mockMybook;

    @InjectMocks
    private WishListService wishListServiceUnderTest;

    @Test
    void testSaveMyBooks () {
        // Setup
        final WishList book = new WishList(0, "name", "author", "price");

        // Run the test
        wishListServiceUnderTest.saveMyBooks(book);

        // Verify the results
        verify(mockMybook).save(any(WishList.class));
    }

    @Test
    void testGetAllMyBooks () {
        // Setup
        // Configure WishListRepository.findAll(...).
        final List<WishList> wishLists = List.of(new WishList(0, "name", "author", "price"));
        when(mockMybook.findAll()).thenReturn(wishLists);

        // Run the test
        final List<WishList> result = wishListServiceUnderTest.getAllMyBooks();

        // Verify the results
    }

    @Test
    void testGetAllMyBooks_WishListRepositoryReturnsNoItems () {
        // Setup
        when(mockMybook.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<WishList> result = wishListServiceUnderTest.getAllMyBooks();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testDeleteById () {
        // Setup
        // Run the test
        wishListServiceUnderTest.deleteById(0);

        // Verify the results
        verify(mockMybook).deleteById(0);
    }
}
