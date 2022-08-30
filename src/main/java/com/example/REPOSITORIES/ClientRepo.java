package com.example.REPOSITORIES;

import com.example.MODELS.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
