package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;

public class PlatDaoMemoireTest {

	private PlatDaoMemoire platDaoMemoire;
	// TODO

	@BeforeEach
	void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	// TODO
	@Test
	void listerPlatsVideALInitialisation() {
        List<Plat> resultat = platDaoMemoire.listerPlats();
        
        assertEquals(0, resultat.size());

		
	}

	// TODO
	@Test
	void ajouterPlatCasPassants() {
		// TODO
        List<Plat> resultat = platDaoMemoire.listerPlats();
        
        platDaoMemoire.ajouterPlat("pizza", 2000);
        
        assertEquals(1, resultat.size());
        
        

	}

}
