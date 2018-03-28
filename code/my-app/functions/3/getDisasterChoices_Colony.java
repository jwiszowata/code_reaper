public Stream<RandomChoice<Disaster>> getDisasterChoices() {
    return flatten(getColonyTiles(), ct -> ct.getWorkTile().getDisasterChoices());
}