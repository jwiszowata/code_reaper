public List<Unit> createUnits(List<AbstractUnit> abstractUnits, Location location) {
    if (location == null)
        return Collections.<Unit>emptyList();
    List<Unit> units = new ArrayList<>();
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    for (AbstractUnit au : abstractUnits) {
        UnitType type = au.getType(spec);
        Role role = au.getRole(spec);
        if (!type.isAvailableTo(this)) {
            logger.warning("Ignoring abstract unit " + au + " unavailable to: " + getId());
            continue;
        }
        if (!role.isAvailableTo(this, type)) {
            logger.warning("Ignoring abstract unit " + au + " with role " + role + " unavailable to: " + getId());
            continue;
        }
        for (int i = 0; i < au.getNumber(); i++) {
            ServerUnit su = new ServerUnit(game, location, this, type, role);
            units.add(su);
        }
    }
    return units;
}