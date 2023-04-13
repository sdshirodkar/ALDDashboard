package com.example.ald.controller;

import com.example.ald.entities.GridCollDefinition;
import com.example.ald.entities.RestResponse;
import com.example.ald.entities.ald.Borrower;
import com.example.ald.service.AldService;
import com.example.ald.service.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AldController {

    @Autowired
   private AldService aldService;

    @Autowired
    private LenderService lenderService;

    @GetMapping("/ald/collDefinition")
    private ResponseEntity<List<GridCollDefinition>> getCollDefinition(){

        return new ResponseEntity<>(aldService.getCollDefFromRepo(),HttpStatus.OK);
    }

    @GetMapping("ald/lender/{orgId}")
    public ResponseEntity<List<RestResponse<Borrower>>> fetchData(@PathVariable Integer orgId){
        return new ResponseEntity<>(lenderService.fetchDataFromALDForLender(orgId), HttpStatus.OK);
    }



}
