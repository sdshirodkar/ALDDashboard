package com.example.ald.controller;

import com.example.ald.entities.GridCollDefinition;
import com.example.ald.repository.AldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AldController {

    @Autowired
   private AldRepository aldRepository;

    @GetMapping("/ald/collDefinition")
    private List<GridCollDefinition> getCollDefinition(){
        String collDefFieldIds= aldRepository.getCollDefFieldIds();
        return aldRepository.getCollDeffData(getDataFromString(collDefFieldIds));
    }

    public ArrayList<Integer> getDataFromString(String str){
        ArrayList<Integer> finalData = new ArrayList();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch!=','){
                int data = ch - '0';
                finalData.add(data);
            }
        }
        return finalData;
    }

}
