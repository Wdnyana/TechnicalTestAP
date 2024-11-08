
package com.purwa.TechnicalTestAP.repository;

import com.purwa.TechnicalTestAP.model.vacancyTable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface vacancyRepository extends MongoRepository<vacancyTable, String> {
  List<vacancyTable> findByExpiryDateAfter(LocalDate currentDate);

  @SuppressWarnings("null")
  Optional<vacancyTable> findById(String id);
}
