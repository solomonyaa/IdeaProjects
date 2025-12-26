public class Main {

    public static void main(String[] args) {

        MobilePhone mp = new MobilePhone("0547789822");
        Contact c1 = new Contact("Vasily", "123");
        Contact c2 = new Contact("Lyosha", "54321");

        mp.addNewContact(c1);
        mp.addNewContact(c2);
        mp.printContacts();

        Contact c3 = new Contact("Ilusha", "54321");


        mp.updateContact(c2, c3);
        mp.printContacts();

        mp.removeContact(c1);
        mp.printContacts();

        var alec = new Contact("Alec", "998776584");

        mp.addNewContact(alec);
        mp.printContacts();

        System.out.println(mp.queryContact("Alec").getPhoneNumber());
    }
}