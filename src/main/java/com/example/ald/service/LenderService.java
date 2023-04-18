package com.example.ald.service;

import com.example.ald.entities.RestResponse;
import com.example.ald.entities.ald.Borrower;
import com.example.ald.repository.AldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LenderService {

    @Autowired
    private AldRepository aldRepository;

    @Autowired
    private AldService aldService;
    private final HashMap<Integer,String> borrowerOrgMapping = new HashMap<>();

    public List<RestResponse<Borrower>> fetchData(Integer orgId){
        List<Integer> AllLEIDs = aldService.getLEIDsForOrg(orgId);

        List<RestResponse<Borrower>> responseDataList = new ArrayList<>();

        for(int i : AllLEIDs){
            System.out.println("Getting Data for legal entity Id "+i);
            List<RestResponse<Borrower>> LEData = getAldFundInfoForLenderLEID(i);
            responseDataList.addAll(LEData);
        }
        return responseDataList;

    }

    //Getting data for LenderLegalEntityID from ald
    public List<RestResponse<Borrower>> getAldFundInfoForLenderLEID(Integer legalEntityId){

        List<Borrower> aldFundDataforLenderLE = aldRepository.getAldFundDataforLenderLE(legalEntityId);
        List<RestResponse<Borrower>> responseDataBorrower = new ArrayList<>();

        for(Borrower borrower: aldFundDataforLenderLE){
            Integer borrowerLegalEntityId  = borrower.getBorrowerLegalEntityId();
            String borrowerName;

            if (borrowerOrgMapping.containsKey(borrowerLegalEntityId)){
                borrowerName = borrowerOrgMapping.get(borrowerLegalEntityId);
            }else{
                borrowerName = aldRepository.getOrgNameForLEID(borrowerLegalEntityId);
                borrowerOrgMapping.put(borrowerLegalEntityId,borrowerName);
            }

            borrower.setBorrowerName(borrowerName.substring(1,borrowerName.length()-1));

            RestResponse<Borrower> restResponse = new RestResponse<>(borrower);
            responseDataBorrower.add(restResponse);
        }
        return responseDataBorrower;

    }





}
