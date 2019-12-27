package com.practice.practice1.controller;

import com.practice.practice1.Exceptions.HandleException;
import com.practice.practice1.model.PracticeModel;
import com.practice.practice1.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/apis")
public class PracticeController {
    @Autowired
    PracticeRepository practiceRepository;

    @GetMapping("/getallmodels")
    public List<PracticeModel> getAllModel() {
        return practiceRepository.findAll();
    }

    @PostMapping("/postallmodels")
    public PracticeModel createModel(@Valid @RequestBody PracticeModel practiceModel){
        return practiceRepository.save(practiceModel);
    }



    @GetMapping("/practice1/{id}")
    public PracticeModel getById(@PathVariable(value = "id") Integer Id) {
        return practiceRepository.findById(Id).orElseThrow(()-> new HandleException("PracticeModel","Id", Id));
    }

    @PutMapping("/practice1/{id}")
    public PracticeModel update(@PathVariable(value = "id") Integer Id,
                                @Valid @RequestBody PracticeModel practiceModel) {
        PracticeModel practice1=practiceRepository.findById(Id).orElseThrow(()-> new HandleException("PracticeModel","Id", Id));

        practice1.setName(practiceModel.getName());
        practice1.setLocation(practiceModel.getLocation());

        return practiceRepository.save(practice1);

    }

    @DeleteMapping("/practice1/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer Id){


       PracticeModel practiceModel = practiceRepository.findById(Id).orElseThrow(()-> new HandleException("PracticeModel","Id", Id));
       practiceRepository.delete(practiceModel);

       return ResponseEntity.ok().build();

    }
}