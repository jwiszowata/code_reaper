private void conciseHeaders(Market market) {
    reportPanel.add(new JSeparator(JSeparator.HORIZONTAL), "newline, span, growx");
    reportPanel.add(newLabel("report.colony.name.header", null, null, stpld("report.colony.name")), "newline");
    reportPanel.add(newLabel("report.colony.grow.header", null, null, stpld("report.colony.grow")));
    reportPanel.add(newLabel("report.colony.explore.header", null, null, stpld("report.colony.explore")));
    for (TileImprovementType ti : this.spec.getTileImprovementTypeList()) {
        if (ti.isNatural())
            continue;
        String key = "report.colony.tile." + ti.getSuffix() + ".header";
        reportPanel.add(newLabel(key, null, null, stpld(key)));
    }
    for (GoodsType gt : this.goodsTypes) {
        ImageIcon icon = new ImageIcon(this.lib.getSmallIconImage(gt));
        JLabel l = newLabel(null, icon, null, stpl("report.colony.production.header").addNamed("%goods%", gt));
        l.setEnabled(market == null || market.getArrears(gt) <= 0);
        reportPanel.add(l);
    }
    final UnitType type = spec.getDefaultUnitType(getMyPlayer());
    ImageIcon colonistIcon = new ImageIcon(this.lib.getTinyUnitImage(type, false));
    reportPanel.add(newLabel(null, colonistIcon, null, stpld("report.colony.birth")));
    reportPanel.add(newLabel("report.colony.making.header", null, null, stpld("report.colony.making")));
    reportPanel.add(newLabel("report.colony.improve.header", null, null, stpld("report.colony.improve")));
    reportPanel.add(new JSeparator(JSeparator.HORIZONTAL), "newline, span, growx");
}