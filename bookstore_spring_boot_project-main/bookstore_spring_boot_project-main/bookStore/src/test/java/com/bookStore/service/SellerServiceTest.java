package com.bookStore.service;

import com.bookStore.entity.Seller;
import com.bookStore.repository.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class SellerServiceTest {

    @Mock
    private SellerRepository mockSellerRepository;

    private SellerService sellerServiceUnderTest;

    @BeforeEach
    void setUp () {
        sellerServiceUnderTest = new SellerService(mockSellerRepository);
    }

    @Test
    void testGetAllSellers () {
        // Setup
        // Configure SellerRepository.findAll(...).
        final Seller seller = new Seller();
        seller.setId(0L);
        seller.setCompanyName("companyName");
        seller.setContactPerson("contactPerson");
        seller.setEmail("email");
        seller.setPhone("phone");
        final List<Seller> sellers = List.of(seller);
        when(mockSellerRepository.findAll()).thenReturn(sellers);

        // Run the test
        final List<Seller> result = sellerServiceUnderTest.getAllSellers();

        // Verify the results
    }

    @Test
    void testGetAllSellers_SellerRepositoryReturnsNoItems () {
        // Setup
        when(mockSellerRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Seller> result = sellerServiceUnderTest.getAllSellers();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetSellerById () {
        // Setup
        // Configure SellerRepository.findById(...).
        final Seller seller1 = new Seller();
        seller1.setId(0L);
        seller1.setCompanyName("companyName");
        seller1.setContactPerson("contactPerson");
        seller1.setEmail("email");
        seller1.setPhone("phone");
        final Optional<Seller> seller = Optional.of(seller1);
        when(mockSellerRepository.findById(0L)).thenReturn(seller);

        // Run the test
        final Seller result = sellerServiceUnderTest.getSellerById(0L);

        // Verify the results
    }

    @Test
    void testGetSellerById_SellerRepositoryReturnsAbsent () {
        // Setup
        when(mockSellerRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Seller result = sellerServiceUnderTest.getSellerById(0L);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testSaveSeller () {
        // Setup
        final Seller seller = new Seller();
        seller.setId(0L);
        seller.setCompanyName("companyName");
        seller.setContactPerson("contactPerson");
        seller.setEmail("email");
        seller.setPhone("phone");

        // Configure SellerRepository.save(...).
        final Seller seller1 = new Seller();
        seller1.setId(0L);
        seller1.setCompanyName("companyName");
        seller1.setContactPerson("contactPerson");
        seller1.setEmail("email");
        seller1.setPhone("phone");
        when(mockSellerRepository.save(any(Seller.class))).thenReturn(seller1);

        // Run the test
        final Seller result = sellerServiceUnderTest.saveSeller(seller);

        // Verify the results
    }

    @Test
    void testDeleteSeller () {
        // Setup
        // Run the test
        sellerServiceUnderTest.deleteSeller(0L);

        // Verify the results
        verify(mockSellerRepository).deleteById(0L);
    }
}
