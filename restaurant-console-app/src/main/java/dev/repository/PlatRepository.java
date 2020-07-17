package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.entite.Plat;


public interface PlatRepository extends JpaRepository <Plat, Integer>, PagingAndSortingRepository<Plat, Integer> {



}
