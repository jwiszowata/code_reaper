private boolean askSetDestination(Unit unit, Location destination) {
    return askServer().setDestination(unit, destination) && unit.getDestination() == destination;
}