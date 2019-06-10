package com.codeclan.example.PirateService.repositories;

import com.codeclan.example.PirateService.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//this is saying that this will use the jpa repository and can only perform crud actions on pirate objects
//long is needed for the db creating and passing back the id (which is of type long)
@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {



}
