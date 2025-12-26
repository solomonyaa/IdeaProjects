package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class ContactData {

    private static final String phoneData = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;

    private static final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getData(String type) {

        List<Contact> listData = new ArrayList<>();
        type = type.trim();
        boolean isEmail = type.equalsIgnoreCase("email");

        String[] lines;

        if (isEmail) {
            lines = emailData.split("\n");
        } else {
            lines = phoneData.split("\n");
        }

        for (String line : lines) {
            // Split each line by comma
            String[] pairs = line.split(", ");

            String name = pairs[0].trim();
            String mailOrPhone = pairs[1].trim();

            if (isEmail) {
                listData.add(new Contact(name, mailOrPhone));
            } else {
                listData.add(new Contact(name, Long.parseLong(mailOrPhone)));
            }
        }
        return listData;
    }
}