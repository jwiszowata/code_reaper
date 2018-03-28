private Occupation getOccupationFor(Unit unit, boolean userMode, LogBuilder lb) {
    for (Collection<GoodsType> types : getWorkTypeChoices(unit, userMode)) {
        lb.add("\n  ");
        FreeColObject.logFreeColObjects(types, lb);
        Occupation occupation = getOccupationFor(unit, types, lb);
        if (occupation != null)
            return occupation;
    }
    lb.add("\n  => FAILED");
    return null;
}