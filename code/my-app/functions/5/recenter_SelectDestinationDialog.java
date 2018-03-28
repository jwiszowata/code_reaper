private void recenter(Destination destination) {
    if (destination != null && destination.location.getTile() != null) {
        getGUI().setFocus(destination.location.getTile());
    }
}