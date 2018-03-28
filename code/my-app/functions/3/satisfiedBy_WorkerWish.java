public boolean satisfiedBy(Unit unit) {
    return (expertNeeded) ? unit.getType() == unitType : unit.getType().isNaval() == unitType.isNaval();
}