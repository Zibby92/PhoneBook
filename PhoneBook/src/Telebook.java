import java.util.*;

public class Telebook {
    Scanner scanner = new Scanner(System.in);
    private List<Contact> listOfContacts = new ArrayList<>();

    void temporaryAddContacts (){
        listOfContacts.add(new Contact("Robert","Krzyżanowski","123"));
        listOfContacts.add(new Contact("Patryk","Sałajczyk","1234"));
        listOfContacts.add(new Contact("Czarek","Pszonka","12345"));
        listOfContacts.add(new Contact( "Krzysztof","Książek","123455"));
    }

    void addContact(){
        String name;
        String lastName;
        String number;
        Contact temporaryContact;
        do {
            System.out.println("Imię: ");
            name = scanner.nextLine();
            System.out.println("Nazwisko: ");
            lastName = scanner.nextLine();
            System.out.println("Numer telefonu: ");
            number = scanner.nextLine();
            temporaryContact = (new Contact(name, lastName, number));
        }while(isTheSame(temporaryContact));
        listOfContacts.add(temporaryContact);
    }

    boolean isTheSame(Contact contact){
        for (Contact con: listOfContacts) {
            if (contact.compareTo(con) == 0) {
                System.out.println("Podany kontakt juz istnieje, zmień dane.");
                return true;
            };
        } return false;
    }

    void findContactByName () {
        String temporaryname;
        System.out.println("Podaj imie szukanego kontaktu: ");
        temporaryname = scanner.nextLine();
        for (Contact con: listOfContacts ) {
            if(con.getName().toLowerCase().startsWith(temporaryname.toLowerCase())) {
                System.out.println(con);
            }
        }
    }
    void findByNumber(){
        String temporarynumber;
        System.out.println("Podaj imie szukanego kontaktu: ");
        temporarynumber = scanner.nextLine();
        for (Contact con: listOfContacts ) {
            if(con.getNumber().toLowerCase().startsWith(temporarynumber.toLowerCase())) {
                System.out.println(con);
            }
        }
    }
    void deleteContact() {
        String serchingName;
        List<Contact> temporaryContact = new ArrayList<>();
        System.out.println("Podaj imie szukanego kontaktu: ");
        serchingName = scanner.nextLine();
        for (int i = 0; i < listOfContacts.size(); i++) {
            if (listOfContacts.get(i).getName().toLowerCase().startsWith(serchingName.toLowerCase())) {
                temporaryContact.add(listOfContacts.get(i));
            }
        }
        for (int i = 0; i < temporaryContact.size(); i++) {
            System.out.println((i + 1) + " " + temporaryContact.get(i));
        }
        System.out.println("Który kontakt chcesz usunąć? Wpisz odpowiadajaca mu cyfre");
        int temporaryContactNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Napewno chcesz usunąć: " + temporaryContact.get(temporaryContactNumber -1));
        System.out.println("Y/N?");
        String temporaryDecision = scanner.nextLine();
        if (temporaryDecision.equals("Y")) {
            listOfContacts.remove(temporaryContact.get(temporaryContactNumber -1));
        }
        for (Contact con :listOfContacts  ) {
            System.out.println(con);
        }
    }
}
