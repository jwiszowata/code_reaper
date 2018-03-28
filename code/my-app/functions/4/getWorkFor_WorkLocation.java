public GoodsType getWorkFor(Unit unit) {
    Occupation occupation = getOccupation(unit, true);
    return (occupation == null) ? null : occupation.workType;
}