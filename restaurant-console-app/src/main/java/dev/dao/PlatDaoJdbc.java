package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public PlatDaoJdbc(DataSource datasource) { 
		this.jdbcTemplate = new JdbcTemplate(datasource); 
		}

	@Override
	public List<Plat> listerPlats() {
		// Recup info de la base
		return jdbcTemplate.query("SELECT * From Plat", new PlatRowMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		jdbcTemplate.update("Insert into Plat(nom, prix) values (?, ?)",nomPlat,prixPlat);
	}

}
