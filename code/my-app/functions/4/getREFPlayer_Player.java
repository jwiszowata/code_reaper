public Player getREFPlayer() {
    Nation ref = getNation().getREFNation();
    return (ref == null) ? null : getGame().getPlayerByNation(ref);
}