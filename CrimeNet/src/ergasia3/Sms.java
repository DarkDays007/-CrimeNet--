package ergasia3;


import java.time.LocalDate;


public class Sms extends Communication {
	
	
	
    private String message;

    
    public Sms(String number1, String number2, LocalDate date, String message) {
         super(number1, number2, date);
         
         this.message = message;
    }

    public String getMessage() {
        return message;
    }

    
    
    @Override
    public void printInfo() {
       System.out.println("This SMS has the following info:");
        System.out.println("Between " + number1 + " --- " + number2);
         System.out.println("on " + date);
            System.out.println("Text: " + message);
    }
}
