private void removeCargo(Cargo cargo) {
    if (!tRemove(cargo)) {
        throw new RuntimeException("removeCargo " + cargo.toShortString());
    }
    dropTransportable(cargo.getTransportable());
}