private void buildReportMenu() {
    JMenu menu = Utility.localizedMenu("menuBar.report");
    menu.setOpaque(false);
    menu.setMnemonic(KeyEvent.VK_R);
    menu.add(getMenuItem(ReportReligionAction.id));
    menu.add(getMenuItem(ReportLabourAction.id));
    menu.add(getMenuItem(ReportColonyAction.id));
    menu.add(getMenuItem(ReportForeignAction.id));
    menu.add(getMenuItem(ReportIndianAction.id));
    menu.add(getMenuItem(ReportContinentalCongressAction.id));
    menu.add(getMenuItem(ReportMilitaryAction.id));
    menu.add(getMenuItem(ReportNavalAction.id));
    menu.add(getMenuItem(ReportTradeAction.id));
    menu.add(getMenuItem(ReportTurnAction.id));
    menu.add(getMenuItem(ReportRequirementsAction.id));
    menu.add(getMenuItem(ReportCargoAction.id));
    menu.add(getMenuItem(ReportExplorationAction.id));
    menu.add(getMenuItem(ReportHistoryAction.id));
    menu.add(getMenuItem(ReportProductionAction.id));
    menu.add(getMenuItem(ReportEducationAction.id));
    menu.add(getMenuItem(ShowDifficultyAction.id));
    menu.add(getMenuItem(ShowGameOptionsAction.id));
    menu.add(getMenuItem(ShowMapGeneratorOptionsAction.id));
    add(menu);
}