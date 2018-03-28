private boolean addCargo(Cargo cargo, int index, LogBuilder lb) {
    boolean result = tAdd(cargo, index);
    if (result)
        takeTransportable(cargo.getTransportable());
    if (result) {
        lb.add(", added ", cargo.toShortString(), " at ", ((index < 0) ? "end" : Integer.toString(index)));
    } else {
        lb.add(", failed to add ", cargo.toShortString());
    }
    return result;
}