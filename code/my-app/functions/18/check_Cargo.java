public String check(AIUnit aiCarrier) {
    if (transportable == null) {
        return "null transportable";
    } else if (transportable.isDisposed()) {
        return "disposed transportable";
    }
    Locatable l = transportable.getTransportLocatable();
    if (l == null) {
        return "null locatable: " + transportable;
    } else if (l instanceof FreeColGameObject && ((FreeColGameObject) l).isDisposed()) {
        return "locatable disposed";
    }
    Location tLoc = l.getLocation();
    if (tLoc instanceof Unit && tLoc != carrier) {
        return "carrier usurped";
    }
    return null;
}