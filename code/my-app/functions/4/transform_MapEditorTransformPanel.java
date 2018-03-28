public void transform(Tile t) {
    t.changeType(tileType);
    t.removeLostCityRumour();
}