import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {
    private String name;
    private String lastName;
    private String number;


    public Contact(String name, String lastName, String number) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public int compareTo(Contact o) {
        if (name.compareTo(o.getName()) == 0) {
            if (lastName.compareTo(o.lastName) == 0){
                if (number.compareTo(o.getNumber()) == 0){ return 0;};
            }
        return lastName.compareTo(o.getLastName());
        }
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Imię " + name +
                ", Nazwisko " + lastName +
                ", Numer " + number;
    }
}
