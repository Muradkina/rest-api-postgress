package com.mkdb.postgressrestapi.repository;

import com.mkdb.postgressrestapi.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiRepository extends JpaRepository<Kisi,Long> {
}
