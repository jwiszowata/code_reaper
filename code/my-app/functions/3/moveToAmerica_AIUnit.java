public boolean moveToAmerica() {
    return AIMessage.askMoveTo(this, unit.getOwner().getGame().getMap());
}