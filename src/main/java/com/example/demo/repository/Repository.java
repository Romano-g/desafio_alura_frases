package com.example.demo.repository;

import com.example.demo.models.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<Page, Long> {
    @Query("SELECT p FROM Page p ORDER BY FUNCTION('RANDOM') LIMIT 1")
    Page searchRandom();
}
