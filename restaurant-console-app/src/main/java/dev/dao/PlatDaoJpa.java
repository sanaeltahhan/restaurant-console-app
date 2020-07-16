package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository
@Profile("jpa")

public class PlatDaoJpa implements IPlatDao {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Plat> listerPlats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		// TODO Auto-generated method stub

	}

}
