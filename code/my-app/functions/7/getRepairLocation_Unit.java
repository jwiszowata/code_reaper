public Location getRepairLocation() {
    final Player player = getOwner();
    final Colony notHere = getTile().getColony();
    final Predicate<Colony> repairPred = c -> c != notHere && c.hasAbility(Ability.REPAIR_UNITS);
    Location loc = getClosestColony(transform(player.getColonies(), repairPred));
    return (loc != null) ? loc : player.getEurope();
}