package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.dk.entities.City;

/**
 * Created by d.koshlyak on 23.10.2015.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
