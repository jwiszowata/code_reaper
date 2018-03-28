public void itemStateChanged(ItemEvent e) {
    Player player = getOwnerPlayer();
    if (player != null) {
        this.name.setText((this.capital.isSelected()) ? player.getCapitalName(null) : player.getSettlementName(null));
    }
    this.skill.setModel(getSkillModel());
    this.skill.setSelectedItem(is.getLearnableSkill());
    this.units.getModel().setValue(is.getUnitCount());
}