private Unit askEmigrate(Europe europe, int slot) {
    if (europe == null || !MigrationType.validMigrantSlot(slot))
        return null;
    EuropeWas europeWas = new EuropeWas(europe);
    Unit newUnit = null;
    if (askServer().emigrate(getGame(), slot) && (newUnit = europeWas.getNewUnit()) != null) {
        europeWas.fireChanges();
    }
    return newUnit;
}