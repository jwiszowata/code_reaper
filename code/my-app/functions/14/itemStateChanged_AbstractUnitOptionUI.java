public void itemStateChanged(ItemEvent e) {
    JComboBox<String> box = roleUI.getComponent();
    DefaultComboBoxModel<String> model;
    boolean enable = false;
    UnitType type = (UnitType) typeUI.getComponent().getSelectedItem();
    if (type.hasAbility(Ability.CAN_BE_EQUIPPED)) {
        model = new DefaultComboBoxModel<>(roleUI.getOption().getChoices().toArray(new String[0]));
        enable = roleEditable;
    } else {
        model = new DefaultComboBoxModel<>(new String[] { Specification.DEFAULT_ROLE_ID });
    }
    box.setModel(model);
    box.setEnabled(enable);
}