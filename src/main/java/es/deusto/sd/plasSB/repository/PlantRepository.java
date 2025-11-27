package es.deusto.sd.plasSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.deusto.sd.plasSB.entity.Plant;

/**
 * JPA repository for Plant entity.
 * No need to write any methods—.save(), .findAll(), .findById(), etc. come built-in!
 */
public interface PlantRepository extends JpaRepository<Plant, Long> {
    // You don't need to add anything here for basic CRUD
}
