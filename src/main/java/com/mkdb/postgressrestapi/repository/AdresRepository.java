package com.mkdb.postgressrestapi.repository;

import com.mkdb.postgressrestapi.model.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Adres,Long> {
}
