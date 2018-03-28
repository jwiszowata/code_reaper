public int compare(AIUnit a1, AIUnit a2) {
    Location l1 = (a1 == null) ? null : (a1.getUnit() == null) ? null : a1.getUnit().getLocation();
    Location l2 = (a2 == null) ? null : (a2.getUnit() == null) ? null : a2.getUnit().getLocation();
    FreeColObject f1 = (l1 instanceof WorkLocation) ? l1.getColony() : (FreeColObject) l1;
    FreeColObject f2 = (l2 instanceof WorkLocation) ? l2.getColony() : (FreeColObject) l2;
    return FreeColObject.compareIds(f1, f2);
}