public void updateOption() {
    typeUI.updateOption();
    roleUI.updateOption();
    numberUI.updateOption();
    UnitType type = typeUI.getOption().getValue();
    String roleId = roleUI.getOption().getValue();
    int number = numberUI.getOption().getValue();
    getOption().setValue(new AbstractUnit(type, roleId, number));
}