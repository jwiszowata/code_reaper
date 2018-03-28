public boolean hasCarrierWithSpace(int space) {
    return any(getUnits(), u -> u.isCarrier() && !u.isDamaged() && u.getSpaceLeft() >= space);
}