private boolean askEmbark(Unit unit, Unit carrier) {
    ColonyWas colonyWas = (unit.getColony() != null) ? new ColonyWas(unit.getColony()) : null;
    EuropeWas europeWas = (unit.isInEurope()) ? new EuropeWas(unit.getOwner().getEurope()) : null;
    UnitWas unitWas = new UnitWas(unit);
    if (askServer().embark(unit, carrier, null) && unit.getLocation() == carrier) {
        sound("sound.event.loadCargo");
        unitWas.fireChanges();
        if (colonyWas != null)
            colonyWas.fireChanges();
        if (europeWas != null)
            europeWas.fireChanges();
        return true;
    }
    return false;
}