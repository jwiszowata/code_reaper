public WorkLocation getWorkLocationFor(Unit unit, GoodsType goodsType) {
    if (goodsType == null)
        return getWorkLocationFor(unit);
    Occupation occupation = getOccupationFor(unit, goodsType.getEquivalentTypes());
    return (occupation == null) ? null : occupation.workLocation;
}