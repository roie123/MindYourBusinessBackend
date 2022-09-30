package com.example.REPOSITORIES;

import com.example.MODELS.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    @Query(value = "select * from client ORDER BY rand() limit 1;",nativeQuery = true)
    public Client findRandomClient();

    @Query(value = "SELECT * FROM client WHERE is_active=1;",nativeQuery = true)
    public List<Client> findActiveClients();

    @Query(value = "SELECT * FROM client WHERE is_active=0;",nativeQuery = true)
    public List<Client> findRemovedClients();



}
