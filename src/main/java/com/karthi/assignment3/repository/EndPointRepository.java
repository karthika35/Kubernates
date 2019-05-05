package com.karthi.assignment3.repository;

import com.karthi.assignment3.model.EndPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndPointRepository extends CrudRepository<EndPoint, Long> {
    EndPoint findFirstByName(String state);

    EndPoint findFirstByAbbr(String code);
}