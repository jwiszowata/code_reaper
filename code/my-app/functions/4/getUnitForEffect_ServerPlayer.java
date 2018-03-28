public Unit getUnitForEffect(Colony colony, Effect effect, Random random) {
    List<Unit> units = transform(colony.getAllUnitsList(), u -> effect.appliesTo(u.getType()));
    return (units.isEmpty()) ? null : getRandomMember(logger, "Select unit for effect", units, random);
}