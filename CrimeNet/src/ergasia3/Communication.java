package ergasia3;
import java.time.LocalDate;

public abstract class Communication {
    protected String number1;
    protected String number2;
    protected LocalDate date;

    public Communication(String number1, String number2, LocalDate date) {
        this.number1 = number1;
        this.number2 = number2;
        this.date = date;
    }

    public abstract void printInfo();

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }
}
