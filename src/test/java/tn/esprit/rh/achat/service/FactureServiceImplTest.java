package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {
    @InjectMocks
    FactureServiceImpl factureService;

    @Mock
    FactureRepository factureRepository;

    @Test
    public void testGetallFactures() {
        // Mock the repository to return two Facture instances with specific properties
        when(factureRepository.findAll()).thenReturn(Stream
                .of(new Facture(1L, 20.0f, 30.0f, new Date(), new Date(), true, null, null, null),
                        new Facture(2L, 15.0f, 25.0f, new Date(), new Date(), true, null, null, null))
                .collect(Collectors.toList()));

        // Test the retrieveAllFactures method
        List<Facture> factures = factureService.retrieveAllFactures();
        assertEquals(2, factures.size());

        // Add more assertions as needed to validate the behavior of your service.
        // For example, you can check specific properties of the returned Factures.
        assertEquals(1L, factures.get(0).getId());
        assertEquals(20.0f, factures.get(0).getAmount1());
        assertEquals(2L, factures.get(1).getId());
        assertEquals(15.0f, factures.get(1).getAmount1());
    }

    @Test
    public void retrieveFactureTest() {
        Long id = 3L;
        Facture expectedFacture = new Facture(id, 32.65f, 164.84f, new Date("2022-10-15"), new Date("2022-10-23"), true, null, null, null);

        // Mock the repository to return the expected Facture instance
        when(factureRepository.findById(id)).thenReturn(Optional.of(expectedFacture));

        // Test the retrieveFacture method
        Facture f = factureService.retrieveFacture(id);
        assertNotNull(f);

        // Add more assertions to verify the properties of the returned Facture.
        assertEquals(id, f.getId());
        assertEquals(32.65f, f.getAmount1());
        assertEquals(164.84f, f.getAmount2());

        // Add more assertions as needed.

        // Verify that the findById method was called with the expected argument.
        verify(factureRepository).findById(id);
    }
}
