package dev.repository;

import java.util.Comparator;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.entite.Plat;

@SpringJUnitConfig(classes = { JpaConfig.class, DataSourceH2TestConfig.class})
@ActiveProfiles("jpa")
public class PlatRepositoryIntegrationTest {
	
	@Autowired
	private PlatRepository pR;
	
	@Test
	public void testFindAll() {
		
		List<Plat> plats = pR.findAll();
		
		Assertions.assertThat(plats).hasSize(6);
		
	}
	
	@Test 
	public void testFindAllSortAsc() {
		// AUTRE METHODE
		//List <Plat> plats = pR.findAll(Sort.by(Sort.Direction.ASC, "prixEnCentimesEuros"));
		
		// AUTRE METHODE
		//TypedSort<Plat> platTS = Sort.sort(Plat.class);
		//Sort sort = platTS.by(Plat::getPrixEnCentimesEuros).ascending();
		//List<Plat> plats = pR.findAll(sort);


		List<Plat> plats = pR.findAll(Sort.sort(Plat.class).by(Plat::getPrixEnCentimesEuros).ascending());
		
		Assertions.assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros));
	}
	
	@Test
	public void testFindAllSortDesc() {
		
		List<Plat> plats = pR.findAll(Sort.sort(Plat.class).by(Plat::getPrixEnCentimesEuros).descending());
		
		Assertions.assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros).reversed());
		
	}
	
	@Test
	public void testFindAllPageable() {
		
		Pageable p1 = PageRequest.of(1, 3,Sort.by("prix").ascending());
		
		Page<Plat> plats = pR.findAll(PageRequest.of(1, 3));
		
	}

}
