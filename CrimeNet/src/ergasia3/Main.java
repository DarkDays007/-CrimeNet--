//Author:Fourkan Mechmet


package ergasia3;


import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry();

        Suspect bob = new Suspect("Bob Robson", "Frozen Bear", "Berlin");
        bob.addNumber("00496955444444");

        
        
        Suspect danny = new Suspect("Danny Rust", "Rusty Knife", "Hamburg");
        danny.addNumber("00478484777777");
        danny.addNumber("00446999888888");

        Suspect elena = new Suspect("Elena Doom", "Silent Whisper", "Munich");
        elena.addNumber("00498001231234");

         registry.addSuspect(bob);
         registry.addSuspect(danny);
         registry.addSuspect(elena);
 
         registry.addCommunication(new PhoneCall("00496955444444", "00478484777777",
               LocalDate.of(2024, 10, 16), 240));
      registry.addCommunication(new Sms("00478484777777", "00446999888888",
                LocalDate.of(2024, 10, 14), "Gun Received from Rusty Knife"));

       
        SearchPage searchPage = new SearchPage(registry);
        searchPage.setVisible(true);
    }
}
