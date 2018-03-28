public void actionPerformed(ActionEvent ae) {
    Unit unit = getGUI().getActiveUnit();
    if (unit != null)
        getGUI().showTradeRoutePanel(unit);
}