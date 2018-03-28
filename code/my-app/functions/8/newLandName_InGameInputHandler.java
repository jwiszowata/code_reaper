private void newLandName(NewLandNameMessage message) {
    final Game game = getGame();
    final Unit unit = message.getUnit(getMyPlayer());
    final String defaultName = message.getNewLandName();
    if (unit == null || defaultName == null || !unit.hasTile())
        return;
    invokeLater(() -> igc().newLandName(defaultName, unit));
}