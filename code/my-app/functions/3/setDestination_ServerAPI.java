public boolean setDestination(Unit unit, Location destination) {
    return ask(unit.getGame(), new SetDestinationMessage(unit, destination));
}