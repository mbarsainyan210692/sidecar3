package com.sydecar;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Ownership ownership= new Ownership();
        Map<String, Float> distribution = new HashMap();
        distribution.put("id-007", 60F);
        distribution.put("id-c1", 20F);

        ownership.addOwnership("id-mi6", "British Intelligence LLC", 
        "entity", distribution);
        ownership.addOwnership("id-007", "James Bond", 
        "person", null);


        Map<String, Float> distribution2 = new HashMap();
        distribution2.put("id-007", 20F);
        distribution2.put("id-006", 10F);
        ownership.addOwnership("id-c1", "Cool Identity Associates LLC", 
        "entity", distribution2);


        ownership.addOwnership("id-006", "Alec Trevelyan", 
        "person", null);

         Map<String, Float> owners = ownership.getOwnershipDistribution("id-mi6");

         for(String id:owners.keySet()){
            System.err.println(id + "---" + owners.get(id));
         }

    }
    
}
