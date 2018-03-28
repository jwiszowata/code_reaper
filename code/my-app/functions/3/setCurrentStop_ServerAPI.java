public boolean setCurrentStop(Unit unit, int index) {
    return ask(unit.getGame(), new SetCurrentStopMessage(unit, index));
}