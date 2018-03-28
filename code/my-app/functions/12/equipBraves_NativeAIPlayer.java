public void equipBraves(IndianSettlement is, LogBuilder lb) {
    final Comparator<Unit> comp = getGame().getCombatModel().getMilitaryStrengthComparator();
    for (Unit u : sort(is.getAllUnitsList(), comp)) {
        Role r = is.canImproveUnitMilitaryRole(u);
        if (r != null) {
            Role old = u.getRole();
            if (getAIUnit(u).equipForRole(r) && u.getRole() != old) {
                lb.add(u, " upgraded from ", old.getSuffix(), ", ");
            }
        }
    }
}