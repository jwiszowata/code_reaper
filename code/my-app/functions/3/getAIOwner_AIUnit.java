public AIPlayer getAIOwner() {
    return (unit == null) ? null : (unit.getOwner() == null) ? null : getAIMain().getAIPlayer(unit.getOwner());
}