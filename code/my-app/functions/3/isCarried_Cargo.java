public boolean isCarried() {
    return transportable != null && transportable.getLocation() == carrier;
}