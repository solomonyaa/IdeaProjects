public class Main
{
    public static void main(String[] args)
    {
        /*Printer defaultPrinter = new Printer();
        var sheets = defaultPrinter.printPages(51);
        System.out.println("Number of sheets of paper to print: " + sheets);
        defaultPrinter.printPages(1000);
        defaultPrinter.printPages(20);

        System.out.println("Toner percentage: " + defaultPrinter.getTonerPercentage());
        System.out.println("Total pages printed: " + defaultPrinter.getPagesPrinted());*/

        /*Printer printer = new Printer(100, true);
        var sheets = printer.printPages(51);
        System.out.println("Number of sheets of paper to print: " + sheets);
        printer.printPages(1000);
        printer.printPages(20);

        System.out.println("Toner percentage: " + printer.getTonerPercentage());
        System.out.println("Total pages printed: " + printer.getPagesPrinted());*/

        Printer printer2 = new Printer(50, false);
        System.out.println("Initial page count = " + printer2.getPagesPrinted());

        int pagesPrinted = printer2.printPages(5);
        System.out.printf("Current job pages: %d, Printer total: %d %n",
                pagesPrinted, printer2.getPagesPrinted());

        pagesPrinted = printer2.printPages(10);
        System.out.printf("Current job pages: %d, Printer total: %d %n",
                pagesPrinted, printer2.getPagesPrinted());

        int toner_per = printer2.getTonerPercentage();
        System.out.printf("Toner percentage is: %d", toner_per);
    }
}