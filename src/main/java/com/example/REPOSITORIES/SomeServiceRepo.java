package com.example.REPOSITORIES;

import com.example.MODELS.SomeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeServiceRepo extends JpaRepository<SomeService,Long> {

}
