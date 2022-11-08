package com.succulents.repository;

import com.succulents.model.Succulent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucculentRepository extends JpaRepository<Succulent, Long> {
}
