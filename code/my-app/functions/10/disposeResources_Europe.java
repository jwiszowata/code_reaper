public void disposeResources() {
    Player owner = getOwner();
    if (owner != null) {
        owner.setEurope(null);
        HighSeas highSeas = owner.getHighSeas();
        if (highSeas != null)
            highSeas.removeDestination(this);
    }
    super.disposeResources();
}