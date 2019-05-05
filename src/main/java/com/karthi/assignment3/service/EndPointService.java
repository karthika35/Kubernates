package com.karthi.assignment3.service;

import com.karthi.assignment3.model.EndPoint;
import com.karthi.assignment3.repository.EndPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndPointService {
    @Autowired
    private EndPointRepository endPointRepository;

    public void save(List<EndPoint> endPointList) {
        endPointRepository.saveAll(endPointList);
    }

    public EndPoint findFirstByAbbr(String code) {
        return endPointRepository.findFirstByAbbr(code);
    }

    public EndPoint findFirstByName(String stateName) {
        return endPointRepository.findFirstByName(stateName);
    }

    public Iterable<EndPoint> findAll() {
        return endPointRepository.findAll();
    }
}
