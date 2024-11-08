package com.purwa.TechnicalTestAP.controller;

import com.purwa.TechnicalTestAP.model.vacancyTable;
import com.purwa.TechnicalTestAP.service.vacancyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancy")
public class vacancyController {
    @Autowired
    private final vacancyService vacancyService;

    public vacancyController(vacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }
    @GetMapping("/hello")
    public String hello() {
      return "Hello From Tecnical Test Message!! :)";
    }

    @PostMapping
    public ResponseEntity<vacancyTable> createVacancy(@RequestBody vacancyTable vacancy) {
        vacancyTable createdVacancy = vacancyService.createVacancy(vacancy);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVacancy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVacancyById(@PathVariable String id) {
      try {
        vacancyTable vacancy = vacancyService.getVacancyById(id);
        return ResponseEntity.ok(vacancy);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot getting vacancy with ID " + id + " because it not exists!!");
      }
    }

    @GetMapping("/gets")
    public ResponseEntity<?> getAllVacancies() {
      try {
        List<vacancyTable> vacancies = vacancyService.getAllVacancies();
        return ResponseEntity.ok(vacancies);
        
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot geting All vacancy");
      }
    }

    @GetMapping("/active")
    public ResponseEntity<List<vacancyTable>> getActiveVacancies() {
        List<vacancyTable> activeVacancies = vacancyService.getActiveVacancies();
        return ResponseEntity.ok(activeVacancies);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVacancy(@PathVariable String id, @RequestBody vacancyTable vacancy) {
      try {
        vacancyTable updatedVacancy = vacancyService.updateVacancy(id, vacancy);
        return ResponseEntity.ok(updatedVacancy);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot update vacancy with ID " + id + " because it not exists!!");
      }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVacancy(@PathVariable String id) {
        try {
            vacancyService.deleteVacancy(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vacancy with ID " + id + " not found");
      }
  }

}
