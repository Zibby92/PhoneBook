import java.util.NoSuchElementException;
import java.util.Scanner;

public enum BookOptions {
    ADD_CONTACT(1,"Dodaj nowy kontakt"),
    FIND_BY_NAME(2,"Znajdz kontakt po Imieiu"),
    FIND_BY_NUMBER(3,"Znajdz kontakt po numerze telefonu"),
    DELETE_CONTACT(4,"Usuń kontakt"),
    EXIT(5,"Wyjscie z programu");


    int option;
    String optionDescription;

    BookOptions(int option, String optionDescription) {
        this.option = option;
        this.optionDescription = optionDescription;
    }

    public int getOption() {
        return option;
    }

    static BookOptions chooseOptions (int i ){
        if(i<0 || i >BookOptions.values().length ){
            throw new NoSuchElementException("Podałeś zła cyfre");
        }
        for (BookOptions option: BookOptions.values()) {
            if(i == option.getOption()) return option;
        } return null;
    }

    @Override
    public String toString() {
        return option + " - " + optionDescription;
    }
}
