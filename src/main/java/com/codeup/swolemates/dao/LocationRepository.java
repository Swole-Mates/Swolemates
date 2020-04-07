package com.codeup.swolemates.dao;

import com.codeup.swolemates.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query
    Location getLocationById(long id);
    @Query
    Location getLocationByZipcode(String zipcode);
}