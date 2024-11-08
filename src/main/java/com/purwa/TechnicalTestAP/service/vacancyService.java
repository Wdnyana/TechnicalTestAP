package com.purwa.TechnicalTestAP.service;

import com.purwa.TechnicalTestAP.repository.vacancyRepository;
import com.purwa.TechnicalTestAP.model.vacancyTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class vacancyService {
    @Autowired
    private vacancyRepository vacancyRepository;

    public vacancyTable getVacancyById(String id) {
      return vacancyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));
    }

    public List<vacancyTable> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public vacancyTable createVacancy(vacancyTable vacancy) {
      vacancy.setPublishDate(LocalDate.now());
      vacancy.setExpiryDate(LocalDate.now().plusDays(1));

      return vacancyRepository.save(vacancy);
    }

    public List<vacancyTable> getActiveVacancies() {
      return vacancyRepository.findByExpiryDateAfter(LocalDate.now());
    }

    public vacancyTable updateVacancy(String id, vacancyTable vacancy) {
      return vacancyRepository.findById(id).map(existingVacancy -> {
        if (vacancy.getVacancy() != null) {
            existingVacancy.setVacancy(vacancy.getVacancy());
        }
        if (vacancy.getVacancyName() != null) {
            existingVacancy.setVacancyName(vacancy.getVacancyName());
        }
        if (vacancy.getDescription() != null) {
            existingVacancy.setDescription(vacancy.getDescription());
        }
        if (vacancy.getMaximumAge() != null) {
            existingVacancy.setMaximumAge(vacancy.getMaximumAge());
        }
        if (vacancy.getMinimumExperience() != null) {
            existingVacancy.setMinimumExperience(vacancy.getMinimumExperience());
        }
        if (vacancy.getSalary() != null) {
            existingVacancy.setSalary(vacancy.getSalary());
        }
        
        return vacancyRepository.save(existingVacancy);
      }).orElseThrow(() -> new RuntimeException("Vacancy not found"));
  }
  

    public void deleteVacancy(String id) {
      if(!vacancyRepository.existsById(id)) {
        throw new RuntimeException("Vacancy with this id not exists!!");
      }

      vacancyRepository.deleteById(id);
    }
}
