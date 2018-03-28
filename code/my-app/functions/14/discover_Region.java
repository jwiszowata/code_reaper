public List<Region> discover(Player player, Turn turn) {
    List<Region> result = new ArrayList<>();
    this.discoveredBy = player;
    this.discoveredIn = turn;
    this.discoverable = false;
    result.add(this);
    for (Region r : transform(getChildren(), Region::getDiscoverable)) {
        r.discoveredBy = player;
        r.discoveredIn = turn;
        r.discoverable = false;
        result.add(r);
    }
    return result;
}