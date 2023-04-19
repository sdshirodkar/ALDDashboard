package com.example.ald.service;

import com.example.ald.entities.RestResponse;
import com.example.ald.entities.ald.Lender;
import com.example.ald.repository.AldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    private AldRepository aldRepository;

    @Autowired
    private AldService aldService;
    private final HashMap<Integer,String> lenderOrgMapping = new HashMap<>();

    public List<RestResponse<Lender>> fetchData(Integer orgId){
        List<Integer> AllLEIDs = aldService.getLEIDsForOrg(orgId);

        List<RestResponse<Lender>> responseDataList = new ArrayList<>();

        for(int i : AllLEIDs){
            System.out.println("Getting Data for legal entity Id "+i);
            List<RestResponse<Lender>> LELenderData = getAldFundInfoForBorrowerLEID(i);
            responseDataList.addAll(LELenderData);
        }
        return responseDataList;

    }

    //Getting data for BorrowerLegalEntityID from ald
    public List<RestResponse<Lender>> getAldFundInfoForBorrowerLEID(Integer legalEntityId){

        List<Lender> aldFundDataforBorrowerLE = aldRepository.getAldFundDataforBorrowerLE(legalEntityId);
        List<RestResponse<Lender>> responseDataLender = new ArrayList<>();

        for(Lender lender: aldFundDataforBorrowerLE){

            String lenderName = getOrgNameForLender(lender.getLenderLegalEntityId());
            lender.setLenderName(lenderName);

            //Getting status
            String status = lender.getFund().getStatus();
            lender.getFund().setStatus(aldService.getStatus(status));

            //Getting pendingSinceInitiation
            String pendingSinceIntiation = aldService.getPendingSinceIntiation(
                    lender.getFund().getInitiationDate(),
                    lender.getFund().getStatus());
            lender.getFund().setPendingSinceInitiation(pendingSinceIntiation);

            responseDataLender.add(new RestResponse<>(lender));
        }
       return  responseDataLender;
    }

    private String getOrgNameForLender(Integer lenderLegalEntityId){
        String lenderName;

        if (lenderOrgMapping.containsKey(lenderLegalEntityId)){
            lenderName = lenderOrgMapping.get(lenderLegalEntityId);
        }else{
            lenderName = aldRepository.getOrgNameForLEID(lenderLegalEntityId);
            lenderOrgMapping.put(lenderLegalEntityId,lenderName);
        }
        return lenderName.substring(1,lenderName.length()-1);

    }


}
