import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;

public class TelebookController implements Serializable {

    Telebook telebook = new Telebook();
    void chooseOption(){
        telebook.loadFile();
        int chose = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Wybierz opcje");
            printOptions();
            try {
                chose = scanner.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Nie wpisales poprawnego znaku");
            }
            switch (BookOptions.chooseOptions(chose)) {
                case ADD_CONTACT -> telebook.addContact();
                case FIND_BY_NAME -> telebook.findContactByName();
                case FIND_BY_NUMBER -> telebook.findByNumber();
                case DELETE_CONTACT -> telebook.deleteContact();
                case EXIT -> telebook.saveFile();
            }
        }while (BookOptions.chooseOptions(chose) != BookOptions.EXIT);
    }
    void printOptions(){
        for (BookOptions b:BookOptions.values()) {
            System.out.println(b);
        }
    }
}
