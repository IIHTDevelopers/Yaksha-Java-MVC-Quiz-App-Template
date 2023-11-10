package com.yaksha.training.quiz.repository;

import com.yaksha.training.quiz.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

}
