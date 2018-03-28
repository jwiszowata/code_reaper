private void tryUnitRole(UnitType unitType, String roleId) {
    int count = getCount(roleId, unitType);
    if (count > 0) {
        AbstractUnit au = new AbstractUnit(unitType, roleId, count);
        reportPanel.add(createUnitTypeLabel(au), "sg");
    }
}