public StringTemplate getDestinationLabel() {
    String type = (isPerson()) ? "person" : (isNaval()) ? "ship" : "other";
    return getDestinationLabel(type, getDestination(), getOwner());
}