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
import java.util.Set;
import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Reglement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {
    @InjectMocks
    FactureServiceImpl factureService ;

    @Mock
    FactureRepository factureRepository ;

    @Test
    public void testGetallFactures(){
        when(factureRepository.findAll()).thenReturn(Stream
                .of(new Facture(), new Facture()).collect(Collectors.toList()));
        assertEquals(2, factureService.retrieveAllFactures().size());
    }


    @Test
    public void retrieveFactureTest() {
        Long id = (long) 3;
        when(factureRepository.findById(id)).thenReturn(Optional.of(new Facture(id, 32.65f, 164.84f, new Date("2022-10-15"), new Date("2022-10-23"), true, null, null, null)));
        Facture f = factureService.retrieveFacture(id);
        assertNotNull(f);
        verify(factureRepository).findById(Mockito.anyLong());
    }
}
