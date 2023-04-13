package com.example.ald.service;

import com.example.ald.entities.RestResponse;
import com.example.ald.entities.ald.Borrower;
import com.example.ald.repository.AldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LenderService {

    @Autowired
    private AldRepository aldRepository;

    //Getting data for LenderLegalEntityID from ald
    public List<Borrower> getAldFundInfoForLenderLEID(Integer legalEntityId){

        List<Borrower> aldFundDataforLenderLE = aldRepository.getAldFundDataforLenderLE(legalEntityId);

        return aldFundDataforLenderLE;

    }

    public List<RestResponse<Borrower>> fetchDataFromALDForLender(Integer orgId){
        List<Integer> AllLEIDs = getLEIDsForOrg(orgId);
        List<Borrower> OrgData = new ArrayList<>();
        for(int i : AllLEIDs){
            System.out.println("Getting Data for legal entity Id "+i);
            List<Borrower> LEData = getAldFundInfoForLenderLEID(i);
            OrgData.addAll(LEData);
        }
        List<RestResponse<Borrower>> responseDataList = new ArrayList<>();
        for(Borrower borrower : OrgData){
            RestResponse<Borrower> responseModel= new RestResponse<>(borrower);
            responseDataList.add(responseModel);
        }
        return responseDataList;

    }
    public List<Integer> getLEIDsForOrg(Integer orgId){

       List<Integer> AllLEIDSList = aldRepository.getAllLeIdsForOrg(orgId);
       return AllLEIDSList;
    }


}
