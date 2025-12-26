package dev.lpa;

import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        // keySet returns a Set of the keys stored in the Map.
        // String because it is the type of the key.
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        // Creating a TreeSet passing the keySet to the constructor.
        // This results in a sorted Set with a natural ordering.
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if (contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus Van Pelt exists.");
        }
        System.out.println("-".repeat(150));

        keysView.remove("Daffy Duck");

        // Removing an element from the Set also removes the element from the Map
        System.out.println("Set<String> keysView: ");
        System.out.println(keysView);
        System.out.println("\nMap<String, Contact> contacts: ");
        contacts.forEach((k, v) -> System.out.println(v));

        // Removing an element from this Set doesn't affect the Map because this Set is a copy (new TreeSet)
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println("\nSet<String> copyOfKeys: ");
        System.out.println(copyOfKeys);
        System.out.println("\nMap<String, Contact> contacts: ");
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("*".repeat(150));

        keysView.retainAll(List.of(
                "Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"
        ));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        // Summary
        // The Set returned from the keySet method is backed by the map.
        // This means changes to the Map are reflected in the Set and vice versa.
        // The Set supports element removal, which removes the corresponding mapping from the map.
        // Methods this Set supports are: remove, removeAll, retainAll, clear.

        System.out.println("*".repeat(150));
        keysView.clear();
        System.out.println(contacts);

        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keysView);

        var values = contacts.values();
        values.forEach(System.out::println);

        System.out.println("*".repeat(150));

        // retainAll keeps all the elements in values that exist in the list returned from ContactData.getData
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("*".repeat(150));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        System.out.println("*".repeat(150));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        System.out.println("*".repeat(150));

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size() < contacts.keySet().size()){
            System.out.println("Duplicate Values are in the Map");
        }


        System.out.println("*".repeat(150));

        var nodeSet = contacts.entrySet();
        for (var node : nodeSet){
            System.out.println(nodeSet.getClass().getName());
            if(!node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("Key: " + node.getKey() + " doesn't match the name: " + node.getValue().getName());
            }
        }
    }
}
