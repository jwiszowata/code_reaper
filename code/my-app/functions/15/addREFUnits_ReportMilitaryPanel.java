protected void addREFUnits() {
    final Specification spec = getSpecification();
    final Player player = getMyPlayer();
    final Nation refNation = player.getNation().getREFNation();
    reportPanel.add(Utility.localizedLabel(refNation), SPAN_SPLIT_2);
    reportPanel.add(new JSeparator(JSeparator.HORIZONTAL), "growx");
    List<AbstractUnit> refUnits = player.getREFUnits();
    if (refUnits != null) {
        for (AbstractUnit au : refUnits) {
            if (!au.getType(spec).isNaval()) {
                reportPanel.add(createUnitTypeLabel(au), "sg");
            }
        }
    }
}