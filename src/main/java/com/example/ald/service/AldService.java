package com.example.ald.service;

import com.example.ald.entities.GridCollDefinition;
import com.example.ald.repository.AldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
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

// Calculating pendingSinceInitiation using the initiation Date of the fund
    public String getPendingSinceIntiation(LocalDateTime initiationDate, String status){
        if(status != "Pending"){
            return "NA";
        }
        LocalDateTime  currentDate = LocalDateTime.now();
        System.out.println(initiationDate.toLocalDate()+" "+currentDate.toLocalDate());
        long differenceInDays = Duration.between(initiationDate,currentDate).toDays();

        if (differenceInDays < 10) return "0-10 (Days)";
        else if (differenceInDays >= 10 && differenceInDays < 50) return "10-50 (Days)";
        else return "50+ Days";

    }


    public String getStatus(String status){
        String result;
        switch (status){
            case "A":
                result = "Approved";
                break;
            case "R":
                result = "Rejected";
                break;
            case "P":
            default: result = "Pending";
        }
        return result;
    }



}
