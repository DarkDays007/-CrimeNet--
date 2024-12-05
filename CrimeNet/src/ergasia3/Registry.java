package ergasia3;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Suspect> suspects;
    private List<Communication> communications;

    public Registry() {
        this.suspects = new ArrayList<>();
        this.communications = new ArrayList<>();
    }

    public void addSuspect(Suspect suspect) {
        if (!suspects.contains(suspect)) {
            suspects.add(suspect);
        }
    }

    public void addCommunication(Communication communication) {
        communications.add(communication);

        Suspect suspect1 = findSuspectByPhoneNumber(communication.getNumber1());
        Suspect suspect2 = findSuspectByPhoneNumber(communication.getNumber2());

        if (suspect1 != null && suspect2 != null && !suspect1.equals(suspect2)) {
            suspect1.addPartner(suspect2);
            suspect2.addPartner(suspect1);
        }
    }

    private Suspect findSuspectByPhoneNumber(String phoneNumber) {
        for (Suspect suspect : suspects) {
            if (suspect.getPhoneNumbers().contains(phoneNumber)) {
                return suspect;
            }
        }
        return null;
    }

    public Suspect findSuspectByName(String name) {
        for (Suspect suspect : suspects) {
            if (suspect.getName().equalsIgnoreCase(name)) {
                return suspect;
            }
        }
        return null;
    }

    public List<Sms> getMessagesBetween(List<String> suspectNumbers, String phoneNumber) {
        List<Sms> result = new ArrayList<>();
        for (Communication comm : communications) {
            if (comm instanceof Sms) {
                Sms sms = (Sms) comm;
                if ((suspectNumbers.contains(sms.getNumber1()) && sms.getNumber2().equals(phoneNumber)) ||
                    (suspectNumbers.contains(sms.getNumber2()) && sms.getNumber1().equals(phoneNumber))) {
                    result.add(sms);
                }
            }
        }
        return result;
    }
}

