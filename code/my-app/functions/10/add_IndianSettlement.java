public boolean add(Locatable locatable) {
    boolean result = super.add(locatable);
    if (result && locatable instanceof Unit) {
        Unit indian = (Unit) locatable;
        if (indian.getHomeIndianSettlement() == null) {
            indian.changeHomeIndianSettlement(this);
        }
    }
    return result;
}