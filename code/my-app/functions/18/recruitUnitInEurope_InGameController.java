public boolean recruitUnitInEurope(int index) {
    if (!requireOurTurn() || !MigrationType.validMigrantIndex(index))
        return false;
    final Player player = getMyPlayer();
    if (!player.isColonial())
        return false;
    if (!player.checkGold(player.getRecruitPrice())) {
        getGUI().showInformationMessage("info.notEnoughGold");
        return false;
    }
    Unit newUnit = askEmigrate(player.getEurope(), MigrationType.migrantIndexToSlot(index));
    if (newUnit != null) {
        player.setNextActiveUnit(newUnit);
        getGUI().setActiveUnit(newUnit);
        updateGUI(null);
    }
    return newUnit != null;
}