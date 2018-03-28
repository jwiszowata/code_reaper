public WorkLocation getWorkLocationFor(Unit unit) {
    Occupation occupation = getOccupationFor(unit, false);
    return (occupation == null) ? null : occupation.workLocation;
}