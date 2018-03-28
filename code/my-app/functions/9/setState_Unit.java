public void setState(UnitState s) {
    if (state == s) {
        return;
    } else if (!checkSetState(s)) {
        throw new IllegalStateException("Illegal UnitState transition: " + state + " -> " + s);
    } else {
        setStateUnchecked(s);
    }
}