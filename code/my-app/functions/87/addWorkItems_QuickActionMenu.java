private boolean addWorkItems(final UnitLabel unitLabel) {
    final Unit unit = unitLabel.getUnit();
    if (unit.isCarrier())
        return false;
    final UnitType unitType = unit.getType();
    final GoodsType expertGoods = unitType.getExpertProduction();
    final Colony colony = unit.getLocation().getColony();
    final Specification spec = freeColClient.getGame().getSpecification();
    final WorkLocation current = unit.getWorkLocation();
    final int bonusChange = (current != null) ? 0 : colony.governmentChange(colony.getUnitCount() + 1);
    final int bonus = colony.getProductionBonus();
    Map<JMenuItem, Integer> items = new HashMap<>();
    Map<JMenuItem, Integer> extras = new HashMap<>();
    JMenuItem expertOwned = null;
    JMenuItem expertUnowned = null;
    for (GoodsType type : spec.getGoodsTypeList()) {
        int bestOwnedProd = bonus + bonusChange, bestUnownedProd = bonus + bonusChange;
        WorkLocation bestOwned = null, bestUnowned = null;
        for (WorkLocation wl : colony.getAllWorkLocationsList()) {
            int prod = 0;
            switch(wl.getNoAddReason(unit)) {
                case NONE:
                    prod = wl.getPotentialProduction(type, unitType);
                    if (bestOwnedProd < prod) {
                        bestOwnedProd = prod;
                        bestOwned = wl;
                    }
                    break;
                case ALREADY_PRESENT:
                    prod = wl.getPotentialProduction(type, unitType);
                    if (bestOwnedProd < prod) {
                        bestOwnedProd = prod;
                        bestOwned = (unit.getWorkType() == type) ? null : wl;
                    }
                    break;
                case CLAIM_REQUIRED:
                    prod = wl.getPotentialProduction(type, unitType);
                    if (bestUnownedProd < prod) {
                        bestUnownedProd = prod;
                        bestUnowned = wl;
                    }
                    break;
                default:
                    break;
            }
        }
        if (bestOwned != null && bestOwnedProd > 0) {
            JMenuItem ji = makeProductionItem(type, bestOwned, bestOwnedProd, unitLabel, false);
            if (type == expertGoods) {
                expertOwned = ji;
            } else {
                items.put(ji, bestOwnedProd);
            }
        }
        if (bestUnowned != null && bestUnownedProd > bestOwnedProd && bestUnownedProd > 0) {
            JMenuItem ji = makeProductionItem(type, bestUnowned, bestUnownedProd, unitLabel, true);
            if (type == expertGoods) {
                expertUnowned = ji;
            } else {
                extras.put(ji, bestUnownedProd);
            }
        }
    }
    JMenu container = Utility.localizedMenu("quickActionMenu.changeWork");
    List<JMenuItem> owned = descendingList(items);
    if (expertOwned != null)
        owned.add(0, expertOwned);
    for (JMenuItem j : owned) container.add(j);
    List<JMenuItem> unowned = descendingList(extras);
    if (expertUnowned != null)
        unowned.add(0, expertUnowned);
    if (!unowned.isEmpty()) {
        if (!owned.isEmpty())
            container.addSeparator();
        for (JMenuItem j : unowned) container.add(j);
    }
    if (container.getItemCount() > 0)
        this.add(container);
    if (current != null && unit.getWorkType() != null) {
        JMenuItem ji = Utility.localizedMenuItem("showProductionModifiers");
        ji.addActionListener((ActionEvent ae) -> {
            gui.showWorkProductionPanel(unit);
        });
        this.add(ji);
    }
    return !(owned.isEmpty() && unowned.isEmpty() && current == null);
}