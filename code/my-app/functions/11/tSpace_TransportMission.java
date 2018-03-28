private void tSpace() {
    final Unit carrier = getUnit();
    final int maxHolds = carrier.getCargoCapacity();
    int holds = carrier.getCargoSpaceTaken();
    for (Cargo cargo : cargoes) {
        if (!cargo.isValid())
            continue;
        holds += cargo.getNewSpace();
        cargo.setSpaceLeft(maxHolds - holds);
    }
}