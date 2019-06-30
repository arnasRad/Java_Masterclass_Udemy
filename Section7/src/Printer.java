public class Printer {
    private int tonerLevel = 100;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if(tonerLevel >= 0 && tonerLevel <= 100)
            this.tonerLevel = tonerLevel;

        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    private int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public void fillToner(int fill) {
        if (fill <= 0) {
            System.out.println("Invalid fill level: " + fill +
                    ". Fill level must be in range [1, 100]");
            return;
        }

        int newLevel = tonerLevel + fill;
        if (newLevel > 100) {
            System.out.println("Current toner level is " + tonerLevel +
                    ", error while trying to fill it " + fill +
                    "% more. Can't fill toner more than 100%");
            return;
        }

        this.tonerLevel = newLevel;
        System.out.println("Toner filled by " + fill + "%. New toner level: " +
                this.tonerLevel + "%");
    }

    public void print(int pages) {
        int i = 1;
        while (i <= pages && this.tonerLevel > 0) {
            --this.tonerLevel;
            ++this.pagesPrinted;
            System.out.println("Printing " + i + " page... Toner level after print: " +
                    getTonerLevel() + "%");
            ++i;
        }

        if ((i-1) != pages && tonerLevel == 0) {
            System.out.println("ERROR. Ran out of ink. Fill the toner to print the pages");
            return;
        }

        System.out.println("Print successful. Current total pages printed: " +
                pagesPrinted + ", toner level: " + getTonerLevel() + "%");
    }

    public void showPagesPrintedCount() {
        System.out.println("Total pages printed: " + getPagesPrinted());
    }
}
