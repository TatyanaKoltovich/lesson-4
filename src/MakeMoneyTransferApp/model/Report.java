package MakeMoneyTransferApp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    String textReport;

    public Report(String textReport) {
        this.textReport = textReport;
    }

    public Report() {
        this.textReport = "";
    }

    public String getTextReport() {
        return textReport;
    }

    public void setTextReport(String stringReport) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String text = dtf.format(LocalDateTime.now());

        this.textReport = this.textReport + text + "| " + stringReport + "\n";
    }

    public void setTextReportWithoutDates(String stringReport) {
        this.textReport = this.textReport + stringReport + "\n";
    }
}
