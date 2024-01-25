package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Sign;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface SignRepository extends CrudRepository<Sign,Long> {
    @Override
    ArrayList<Sign> findAll();
}
