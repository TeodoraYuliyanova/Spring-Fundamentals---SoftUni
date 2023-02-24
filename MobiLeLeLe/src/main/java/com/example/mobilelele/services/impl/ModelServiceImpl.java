package com.example.mobilelele.services.impl;

import com.example.mobilelele.repositories.ModelRepository;
import com.example.mobilelele.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;


    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    @Override
    public boolean areImported() {
        return this.modelRepository.count() > 0;
    }

    @Override
    public void imported() {

    }
}
