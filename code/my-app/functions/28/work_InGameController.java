public boolean work(Unit unit, WorkLocation workLocation) {
    if (!requireOurTurn() || unit == null || workLocation == null)
        return false;
    StringTemplate template;
    if (unit.getStudent() != null && !getGUI().confirmAbandonEducation(unit, false))
        return false;
    Colony colony = workLocation.getColony();
    Tile tile = workLocation.getWorkTile();
    if (tile != null) {
        if (tile.hasLostCityRumour()) {
            getGUI().showInformationMessage("tileHasRumour");
            return false;
        }
        if (!unit.getOwner().owns(tile)) {
            if (!claimTile(tile, colony))
                return false;
        }
    }
    ColonyWas colonyWas = new ColonyWas(colony);
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askServer().work(unit, workLocation) && unit.getLocation() == workLocation;
    if (ret) {
        colonyWas.fireChanges();
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}