package com.example.REPOSITORIES;

import com.example.MODELS.IncomeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomItemRepo extends JpaRepository<IncomeItem,Long> {



}
