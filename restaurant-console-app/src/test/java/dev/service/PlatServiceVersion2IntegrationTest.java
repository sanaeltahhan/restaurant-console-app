package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dao.PlatDaoMemoire;
import dev.exception.PlatException;



@ContextConfiguration(classes = {PlatDaoMemoire.class, PlatServiceVersion2.class }) // ne s'utilise que pour les tests , ajouter toutes les classe utiles pour le test
@ExtendWith(SpringExtension.class) // laisser Spring Test gérer le cycle de vie du test
public class PlatServiceVersion2IntegrationTest {
	
	// @Autowired demander au conteneur Spring une instance créée dans le contexte
	@Autowired
    PlatServiceVersion2 platServiceV2;
	
	@Test
	void ajouterPlatValide() {

		platServiceV2.ajouterPlat("chocolat", 4500);
		
		assertEquals(1, platServiceV2.listerPlats().size());

	}
	
	@Test
	void ajouterPlatInvalide() {
		
		assertThatThrownBy (() -> platServiceV2.ajouterPlat("ch", 4500)).isInstanceOf(PlatException.class)
		.hasMessage("un plat doit avoir un nom de plus de 5 caractères");
		

	}
	

}
