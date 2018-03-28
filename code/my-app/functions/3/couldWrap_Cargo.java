public boolean couldWrap(Cargo other) {
    return getCarrierTarget() == other.getCarrierTarget() && getNewSpace() < 0 && other.getNewSpace() < 0;
}