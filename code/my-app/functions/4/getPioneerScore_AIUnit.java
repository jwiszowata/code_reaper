public int getPioneerScore() {
    Unit unit = getUnit();
    return (unit == null) ? -1000 : unit.getPioneerScore();
}