public int getScoutScore() {
    Unit unit = getUnit();
    return (unit == null) ? -1000 : unit.getScoutScore();
}