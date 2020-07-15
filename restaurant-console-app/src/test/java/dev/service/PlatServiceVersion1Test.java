package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.IPlatDao;
import dev.exception.PlatException;

public class PlatServiceVersion1Test {

	private PlatServiceVersion1 platServiceV1;
	IPlatDao dao;

	@BeforeEach
	void setUp() {
		dao = mock(IPlatDao.class);
		platServiceV1 = new PlatServiceVersion1(dao);
	}

	@Test
	void ajouterPlat3caracteres() {

		// Plat plat1 = new Plat("Hamburger", 2000);

		assertThatThrownBy(() -> platServiceV1.ajouterPlat("ha", 5000)).isInstanceOf(PlatException.class)
				.hasMessage("un plat doit avoir un nom de plus de 3 caractères");

	}

	@Test
	void ajouterPlatPrixInvalide() {

		// version JUnit 5
		Assertions.assertThrows(PlatException.class, () -> platServiceV1.ajouterPlat("grain de riz", 20),
				"le prix d'un plat doit être supérieur à 5 €");
	}
	
	@Test
	void ajouterPlatValide() {

		platServiceV1.ajouterPlat("chaussette", 4500);

		verify(dao).ajouterPlat("chaussette", 4500);
	}

}
