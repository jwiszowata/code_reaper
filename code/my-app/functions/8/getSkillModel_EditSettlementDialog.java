private DefaultComboBoxModel<UnitType> getSkillModel() {
    IndianNationType ownerType = getOwnerNationType();
    DefaultComboBoxModel<UnitType> skillModel = new DefaultComboBoxModel<>();
    for (RandomChoice<UnitType> skill : ownerType.getSkills()) {
        skillModel.addElement(skill.getObject());
    }
    return skillModel;
}