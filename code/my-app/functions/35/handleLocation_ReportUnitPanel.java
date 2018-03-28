protected void handleLocation(Location location, String locationName, List<Unit> unitList) {
    if ((unitList == null || unitList.isEmpty()) && !showColonies) {
        return;
    }
    JComponent component;
    if (location == null) {
        component = new JLabel(locationName);
    } else {
        JButton button = Utility.getLinkButton(locationName, null, location.getId());
        button.addActionListener(this);
        component = button;
    }
    reportPanel.add(component, NL_SPAN_SPLIT_2);
    reportPanel.add(new JSeparator(JSeparator.HORIZONTAL), "growx");
    if (unitList == null || unitList.isEmpty()) {
        reportPanel.add(Utility.localizedLabel("none"), "sg");
    } else {
        for (Unit u : sort(unitList, Unit.typeRoleComparator)) {
            JButton unitButton = getUnitButton(u);
            if (u.isCarrier()) {
                reportPanel.add(unitButton, "newline, sg");
                for (Goods goods : u.getGoodsList()) {
                    GoodsLabel goodsLabel = new GoodsLabel(getGUI(), goods);
                    reportPanel.add(goodsLabel);
                }
                for (Unit unitLoaded : u.getUnitList()) {
                    UnitLabel unitLoadedLabel = new UnitLabel(getFreeColClient(), unitLoaded, true);
                    reportPanel.add(unitLoadedLabel);
                }
            } else {
                reportPanel.add(unitButton, "sg");
            }
        }
    }
}