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
    public List<RestResponse<Borrower>> getAldFundInfoForLenderLEID(Integer legalEntityId){

        List<Borrower> aldFundDataforLenderLE = aldRepository.getAldFundDataforLenderLE(legalEntityId);
        List<RestResponse<Borrower>> responseDataBorrower = new ArrayList<>();

        for(Borrower borrower: aldFundDataforLenderLE){
            Integer legalEntityID = borrower.getBorrowerLegalEntityId();
            String borrowerName = aldRepository.getOrgNameForLEID(legalEntityID);
            borrower.setBorrowerName(borrowerName.substring(1,borrowerName.length()-1));

            RestResponse<Borrower> responseModel = new RestResponse<>(borrower);
            responseDataBorrower.add(responseModel);
        }
        return responseDataBorrower;

    }

    public List<RestResponse<Borrower>> fetchDataFromALDForLender(Integer orgId){
        List<Integer> AllLEIDs = getLEIDsForOrg(orgId);
        List<Borrower> OrgData = new ArrayList<>();
        List<RestResponse<Borrower>> responseDataList = new ArrayList<>();
        for(int i : AllLEIDs){
            System.out.println("Getting Data for legal entity Id "+i);
            List<RestResponse<Borrower>> LEData = getAldFundInfoForLenderLEID(i);
            responseDataList.addAll(LEData);
        }
        return responseDataList;

    }
    public List<Integer> getLEIDsForOrg(Integer orgId){

       List<Integer> AllLEIDSList = aldRepository.getAllLeIdsForOrg(orgId);
       return AllLEIDSList;
    }


}
