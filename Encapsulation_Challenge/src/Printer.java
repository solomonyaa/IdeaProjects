public class Printer
{
    private int tonerPercentage;
    private int pagesPrinted;
    private boolean duplex;

    public Printer()
    {
        this.tonerPercentage = 100;
        this.pagesPrinted = 0;
        this.duplex = false;
    }
    public Printer(int tonerPercentage, boolean isDuplex)
    {
        this.tonerPercentage = (tonerPercentage >= 0 && tonerPercentage <= 100) ? tonerPercentage : -1;
        this.pagesPrinted = 0;
        this.duplex = isDuplex;
    }

    public int getTonerPercentage()
    {
        return tonerPercentage;
    }

    public int getPagesPrinted()
    {
        return pagesPrinted;
    }

    public int addToner(int tonerAmount)
    {
        if(tonerPercentage + tonerAmount > 100 || tonerPercentage + tonerAmount < 0)
        {
            return -1;
        }
        tonerPercentage += tonerAmount;
        return tonerPercentage;
    }
    public int printPages(int pages)
    {
        if(tonerPercentage <= 0)
        {
            System.out.println("Toner level is low. Please add toner.");
            return -1;
        }
        if((pages / 10) > tonerPercentage)
        {
            System.out.println("Too many pages to print based on the toner level left.");
            return -1;
        }

        int sheets = duplex ? ((pages / 2) + (pages % 2)) : pages;

        pagesPrinted += sheets;
        tonerPercentage -= pages / 10; // every 10 pages will cause the toner amount to decrease by 1%.

        return sheets;
    }
}
