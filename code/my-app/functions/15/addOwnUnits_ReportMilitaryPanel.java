protected void addOwnUnits() {
    final Specification spec = getSpecification();
    final Player player = getMyPlayer();
    reportPanel.add(Utility.localizedLabel(player.getForcesLabel()), NL_SPAN_SPLIT_2);
    reportPanel.add(new JSeparator(JSeparator.HORIZONTAL), "growx");
    final List<Role> militaryRoles = spec.getMilitaryRolesList();
    for (UnitType ut : spec.getUnitTypeList()) {
        if (isReportable(ut)) {
            tryUnitRole(ut, Specification.DEFAULT_ROLE_ID);
        }
        for (Role r : militaryRoles) {
            tryUnitRole(ut, r.getId());
        }
    }
}