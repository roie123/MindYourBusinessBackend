package com.example.REPOSITORIES;

import com.example.MODELS.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client,Long> {
    @Query(value = "select * from client ORDER BY rand() limit 1;",nativeQuery = true)
    public Client findRandomClient();

}
