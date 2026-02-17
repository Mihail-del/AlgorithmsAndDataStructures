package ua.univercity;

abstract class ReportGenerator {

    public final void generate() {
        System.out.println("> Start Generating Report");
        collectData();
        formatReport();
        System.out.println("> Report Completed\n");
    }

    // Abstract steps to be implemented by children
    protected abstract void collectData();
    protected abstract void formatReport();
}

class DailyReport extends ReportGenerator {

    @Override
    protected void collectData() {
        System.out.println("Step 1: Querying database for today's transactions...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Step 2: Exporting data to correct format...");
    }
}

class FinancialReport extends ReportGenerator {

    @Override
    protected void collectData() {
        System.out.println("Step 1: Gathering financial stats from API...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Step 2: Creating as a spreadsheet...");
    }
}
