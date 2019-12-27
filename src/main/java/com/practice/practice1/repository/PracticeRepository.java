package com.practice.practice1.repository;

import com.practice.practice1.model.PracticeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository  extends JpaRepository<PracticeModel,Integer> {
}
