package com.sydecar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Ownership{

    Map<String, Company> companyOwners= new HashMap<>();
    Map<String, Person> personOwners= new HashMap<>();


    public Map<String, Float> getOwnershipDistribution(String id){
        Map<String, Float> ownershipDivision = new HashMap<>();
        if(companyOwners.containsKey(id)){
            Company currCompany = companyOwners.get(id);
            Map<String, List<Float>> cumulativeOwnership = new HashMap<>();
            getNestedOwnership(currCompany.ownershipMap, cumulativeOwnership , 1F);
            for(String ownerid:cumulativeOwnership.keySet()){
                Float totalPercentage= 0F;
                for(Float percentage:cumulativeOwnership.get(ownerid)){
                    totalPercentage+=percentage;
                }
                ownershipDivision.put(ownerid,totalPercentage);
            }
            return ownershipDivision;
        }

        return null;
    }

    public void getNestedOwnership(Map<String,Float> owners, Map<String, List<Float>> cumulativeOwnership, Float initialPercentage){
        for(String owner:owners.keySet() ) {

            if(personOwners.containsKey(owner)){
                List<Float> existingOwnerships = cumulativeOwnership.getOrDefault(owner, new ArrayList<>());
                existingOwnerships.add(initialPercentage * owners.get(owner));
            } else {
                Company nextCompany = companyOwners.get(owner);
                getNestedOwnership(nextCompany.ownershipMap,cumulativeOwnership, initialPercentage * (owners.get(owner)/100));
            }
        }
    }

    public void  addOwnership(String id, String name, String type, Map<String,Float> owners){

        if(type.equals("entity")) {
            Company company = new Company(id, name, owners);
            companyOwners.put(id, company);
        } else {
            Person person = new Person(id, name);
            personOwners.put(id, person);
        }

    }



}