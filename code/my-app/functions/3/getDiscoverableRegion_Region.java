public Region getDiscoverableRegion() {
    return (getDiscoverable()) ? this : (getParent() != null) ? getParent().getDiscoverableRegion() : null;
}