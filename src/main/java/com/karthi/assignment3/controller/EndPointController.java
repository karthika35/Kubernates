package com.karthi.assignment3.controller;

import com.karthi.assignment3.service.EndPointService;
import com.karthi.assignment3.model.EndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class EndPointController {
    @Autowired
    EndPointService endPointService;

    @GetMapping(path = "codeToState")
    public ResponseEntity<String> codeToState(@RequestParam String code) {
        EndPoint endPoint = endPointService.findFirstByAbbr(code);

        if (isEmpty(endPoint)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(endPoint.getName());
    }

    @GetMapping(path = "stateToCode")
    public ResponseEntity<String> stateToCode(@RequestParam String state) {
        EndPoint endPointDb = endPointService.findFirstByName(state);

        if (isEmpty(endPointDb)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(endPointDb.getAbbr());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<EndPoint>> getAll() {
        Iterable<EndPoint> dDtate = endPointService.findAll();
        return ResponseEntity.ok().body(dDtate);
    }


    private boolean isEmpty(EndPoint endPoint) {
        return endPoint == null;
    }
}
