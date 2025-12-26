import dev.lpa.Contact;
import dev.lpa.ContactData;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Contact c1 = new Contact("Solomon", "solomonyaa@gmail.com", 1234567890);
        System.out.println(c1);

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com",
                "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B) Union of emails (A) with phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A ∩ B) Intersect emails (A) and phones (B)", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B ∩ A) Intersect phones (B) and emails (A)", intersectBA);

        //The intersect operation and the union operation are symmetric operations.
        //Meaning: A ∩ B = B ∩ A
        //And: A ∪ B = B ∪ A

        Set<Contact> AminusB = new HashSet<>(emailContacts);
        AminusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)", AminusB);

        Set<Contact> BminusA = new HashSet<>(phoneContacts);
        BminusA.removeAll(emailContacts);
        printData("(B - A) phones (B) - emails (A)", BminusA);

        Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        symmetricDiff.addAll(BminusA);
        printData("Symmetric Difference: phones and emails", symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric Difference: phones and emails (2)", symmetricDiff2);

    }

    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
        contacts.forEach(System.out::println);
    }
}