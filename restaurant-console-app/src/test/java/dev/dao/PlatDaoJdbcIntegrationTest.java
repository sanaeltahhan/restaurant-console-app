package dev.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.entite.Plat;

@SpringJUnitConfig(classes = { JdbcTestConfig.class, PlatDaoJdbc.class})
@ActiveProfiles("jdbc")
public class PlatDaoJdbcIntegrationTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlatDaoJdbc platDaoJdbc;
	
	/*public PersistanceJdbc(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }*/

	
	@Test
	public void listerPlatsNonVide() {
		
		int result = platDaoJdbc.listerPlats().size();
		
		assertEquals(6, result);
		
	}
	
	/*ajouterPlat qui invoque la méthode PlatDaoJdbc::ajouterPlat et vérifie à l’aide du
JdbcTemplate qu’un plat est bien inséré.*/
	
	@Test 
	public void ajouterPlat() {
		platDaoJdbc.ajouterPlat("Pomme", 3000);
		String sql = "Select * From Plat where nom = 'Pomme'";
		Plat result = jdbcTemplate.queryForObject(sql, new PlatRowMapper());
		Assertions.assertThat(result.getNom()).isEqualTo("Pomme");
		
	}

}
