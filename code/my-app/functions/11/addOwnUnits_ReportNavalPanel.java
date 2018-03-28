protected void addOwnUnits() {
    final Player player = getMyPlayer();
    reportPanel.add(Utility.localizedLabel(player.getForcesLabel()), NL_SPAN_SPLIT_2);
    reportPanel.add(new JSeparator(JSeparator.HORIZONTAL), "growx");
    for (UnitType unitType : getSpecification().getUnitTypeList()) {
        if (!isReportable(unitType))
            continue;
        AbstractUnit au = new AbstractUnit(unitType, Specification.DEFAULT_ROLE_ID, getCount("naval", unitType));
        reportPanel.add(createUnitTypeLabel(au), "sg");
    }
}