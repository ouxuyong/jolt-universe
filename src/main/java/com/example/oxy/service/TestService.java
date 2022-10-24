package com.example.oxy.service;

import com.example.oxy.model.TestModel;

import java.util.List;

public interface TestService {
    boolean saveTest(List<TestModel> testModelList);
}
