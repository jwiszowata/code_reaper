public boolean setWorkFor(Unit unit) {
    Occupation occupation = getOccupation(unit, false);
    return occupation != null && occupation.install(unit);
}