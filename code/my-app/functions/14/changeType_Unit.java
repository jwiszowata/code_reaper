public boolean changeType(UnitType unitType) {
    if (!unitType.isAvailableTo(owner))
        return false;
    setType(unitType);
    if (getMovesLeft() > getInitialMovesLeft()) {
        setMovesLeft(getInitialMovesLeft());
    }
    this.hitPoints = unitType.getHitPoints();
    if (getTeacher() != null && !canBeStudent(getTeacher())) {
        getTeacher().setStudent(null);
        setTeacher(null);
    }
    return true;
}