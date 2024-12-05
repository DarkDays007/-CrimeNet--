package ergasia3;




import java.time.LocalDate;

public class PhoneCall extends Communication {
	
    private int duration;

    public PhoneCall(String number1, String number2, LocalDate date, int duration) {
        super(number1, number2, date);
        this.duration = duration;
    }

    public int getDuration() { 
        return duration;
    }

    @Override
    public void printInfo() {
        System.out.println("This phone call has the following info:");
        System.out.println("Between " + number1 + " --- " + number2);
            System.out.println("on " + date);
          System.out.println("Duration: " + duration);
    }   
}      






