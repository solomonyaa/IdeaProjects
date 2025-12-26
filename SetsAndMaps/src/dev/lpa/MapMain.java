package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(200));

        Map<String, Contact> contactMap = new HashMap<>();

        for (Contact contact : fullList) {
            contactMap.put(contact.getName(), contact);
        }

        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
        System.out.println("-".repeat(200));

        System.out.println(contactMap.get("Charlie Brown"));
        System.out.println("-".repeat(200));

        contactMap.clear();

        for (Contact contact : fullList) {

            // put returns the previous value associated with key
            // or null if there was no mapping for key.
            var duplicate = contactMap.put(contact.getName(), contact);
            if (duplicate != null) {

/*                System.out.println("duplicate = " + duplicate);
                System.out.println("current = " + contact);*/
                contactMap.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
        System.out.println("-".repeat(200));
        contactMap.clear();


        for (Contact contact : fullList) {
            //Only the first of identical elements would be added
            contactMap.putIfAbsent(contact.getName(), contact);
        }
        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-".repeat(200));
        contactMap.clear();

        for (Contact contact : fullList) {

            var duplicate = contactMap.putIfAbsent(contact.getName(), contact);
            if (duplicate != null)
                contactMap.put(contact.getName(), contact.mergeContactData(duplicate));
        }
        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-".repeat(200));
        contactMap.clear();

        fullList.forEach(contact ->
                contactMap.merge(contact.getName(), contact, Contact::mergeContactData));

        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));


        System.out.println("-".repeat(200));
        for (String contactName : new String[]
                {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contactMap.computeIfAbsent(contactName, k -> new Contact(k));
        }

        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-".repeat(200));
        for (String contactName : new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {

            contactMap.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place");
                return v;
            });
        }

        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-".repeat(200));
        contactMap.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-".repeat(200));
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replacedContact = contactMap.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-".repeat(200));
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);

        boolean success = contactMap.replace("Daisy Duck", daisy, updatedDaisy);
        if (success) {
            System.out.println("Successfully replaced element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }

        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));


        System.out.println("-".repeat(200));

        success = contactMap.remove("Daisy Duck", daisy);
        if (success) {
            System.out.println("Successfully removed element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", daisy));
        }

        contactMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));


    }
}
