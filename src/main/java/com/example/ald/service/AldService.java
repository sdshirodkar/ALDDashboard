package com.example.ald.service;

import com.example.ald.entities.GridCollDefinition;
import com.example.ald.repository.AldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AldService {

    @Autowired
    private AldRepository aldRepository;

    //Getting Column definition data for repo
    public List<GridCollDefinition> getCollDefFromRepo(){

        String collDefFieldIds = aldRepository.getCollDefFieldIds();
        if(collDefFieldIds=="[]"){
            aldRepository.insertCollDeffData();
            collDefFieldIds = aldRepository.getCollDefFieldIds();
        }
        return aldRepository.getCollDeffData(collDefFieldIds.substring(1,collDefFieldIds.length()-1));
    }



    public List<Integer> getLEIDsForOrg(Integer orgId){
        //Getting all legalentityIds for Org
        List<Integer> AllLEIDSList = aldRepository.getAllLeIdsForOrg(orgId);

        return AllLEIDSList;
    }


}
