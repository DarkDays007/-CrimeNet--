package ergasia3;

import java.util.ArrayList;
import java.util.List;

public class Suspect {
    private String name;
    
    private String codeName;
    private List<String> phoneNumbers;
    
    private List<Suspect> partners;

    public Suspect(String name, String codeName, String city) {
        this.name = name;
        this.codeName = codeName;
        this.phoneNumbers = new ArrayList<>();
        this.partners = new ArrayList<>();
    }

    public void addNumber(String number) {
        if (!phoneNumbers.contains(number)) {
            phoneNumbers.add(number);
        }
    }

    public void addPartner(Suspect suspect) {
        if (!partners.contains(suspect) && !suspect.equals(this)) {
            partners.add(suspect);
        }
    }
    
    

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getName() {
        return name;
    }
  
    
     
    
    public String getCodeName() {
        return codeName;
    }

    // Add this method
    public List<Suspect> getPartners() {
        return partners;
    }

    public List<Suspect> getSuggestedSuspects() {
        List<Suspect> suggested = new ArrayList<>();
        
        for (Suspect partner : partners) {
            for (Suspect partnerOfPartner : partner.getPartners()) {
            	
                if (!partnerOfPartner.equals(this) && !partners.contains(partnerOfPartner)) {
                     if (!suggested.contains(partnerOfPartner)) {
                       
                    	 suggested.add(partnerOfPartner);
                    }
                }
            }
        }
        return suggested;
    }
}
