public int getSpaceTaken() {
    Locatable l = getTransportLocatable();
    return (l == null) ? 0 : l.getSpaceTaken();
}