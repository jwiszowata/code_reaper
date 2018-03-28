public boolean newRegionName(Region region, Tile tile, Unit unit, String name) {
    return ask(unit.getGame(), new NewRegionNameMessage(region, tile, unit, name));
}