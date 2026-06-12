package com.sydecar;
import java.util.Map;

class Company{
    String id;
    String name;
    Map<String,Float> ownershipMap;

    public Company(String id, String name,Map<String,Float> ownershipMap ) {
        this.id=id;
        this.name= name;
        this.ownershipMap=ownershipMap;
    }

    
}