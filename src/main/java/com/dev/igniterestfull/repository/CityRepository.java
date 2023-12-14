package com.dev.igniterestfull.repository;

import com.dev.igniterestfull.model.City;
import com.dev.igniterestfull.model.CityKey;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.Query;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;
import javax.cache.Cache;
import java.util.List;

import static com.dev.igniterestfull.config.Constants.CITY_CACHE;

@RepositoryConfig(cacheName = CITY_CACHE)
@Repository
public interface CityRepository extends IgniteRepository<City, CityKey> {

    List<Cache.Entry<CityKey, City>> findAllByPopulationGreaterThanEqualOrderByPopulation(int population);

    @Query("SELECT city.name, MAX(city.population), country.name, country.GovernmentForm FROM country " +
            "JOIN city ON city.countrycode = country.code " +
            "GROUP BY city.name, country.name, country.GovernmentForm, city.population " +
            "ORDER BY city.population DESC LIMIT ?")
    List<List<?>> findMostPopulatedCities(int limit);

    @Query("SELECT * FROM City WHERE id = ?")
    Cache.Entry<CityKey, City> findById(int id);
}
