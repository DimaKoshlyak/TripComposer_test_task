package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.dk.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
