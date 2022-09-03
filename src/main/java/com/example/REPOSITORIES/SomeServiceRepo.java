package com.example.REPOSITORIES;

import com.example.MODELS.SomeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeServiceRepo extends JpaRepository<SomeService,Long> {

    @Query(value = "select * from some_service ORDER BY rand() limit 1;",nativeQuery = true)
    public SomeService findRandomService();

}
