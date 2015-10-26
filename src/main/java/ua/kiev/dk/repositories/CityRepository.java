package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.dk.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
