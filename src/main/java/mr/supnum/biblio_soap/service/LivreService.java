package mr.supnum.biblio_soap.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import mr.supnum.server_manager.wsdl.Livre;


@Service
public class LivreService {

    private final Map<String, Livre> livres = new HashMap<>();

    public LivreService() {
        Livre l1 = new Livre();
        l1.setIsbn("ISBN-001");
        l1.setTitre("Spring Boot SOAP");
        l1.setAuteur("SupNum");
        l1.setAnneePublication(2024);
        l1.setDisponible(true);

        livres.put(l1.getIsbn(), l1);
    }

    public Livre getLivre(String isbn) {
        return livres.get(isbn);
    }

    public List<Livre> getAllLivres() {
        return new ArrayList<>(livres.values());
    }

    public Livre addLivre(Livre livre) {
        livres.put(livre.getIsbn(), livre);
        return livre;
    }

    public Livre updateLivre(String isbn, Livre livre) {
        livre.setIsbn(isbn); 
        livres.put(isbn, livre);
        return livre;
    }

    public boolean deleteLivre(String isbn) {
        return livres.remove(isbn) != null;
    }

    public Livre empruntLivre(String isbn) {
        Livre livre = livres.get(isbn);
        if (livre != null) {
            livre.setDisponible(false);
        }
        return livre;
    }

    public Livre returnLivre(String isbn) {
        Livre livre = livres.get(isbn);
        if (livre != null) {
            livre.setDisponible(true);
        }
        return livre;
    }
}
