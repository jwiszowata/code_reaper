public void stopUsing(WorkLocation wl) {
    for (Unit u : wl.getUnitList()) {
        AIMessage.askPutOutsideColony(getAIUnit(u));
    }
    if (colony.getUnitCount() <= 0)
        avertAutoDestruction();
    rearrangeTurn = new Turn(getGame().getTurn().getNumber());
}