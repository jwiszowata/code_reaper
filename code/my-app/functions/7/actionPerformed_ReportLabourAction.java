public void actionPerformed(ActionEvent ae) {
    if (getClientOptions().getInteger(ClientOptions.LABOUR_REPORT) == ClientOptions.LABOUR_REPORT_CLASSIC) {
        getGUI().showReportLabourPanel();
    } else {
        getGUI().showCompactLabourReport();
    }
}