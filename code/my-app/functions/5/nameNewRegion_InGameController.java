public boolean nameNewRegion(final Tile tile, final Unit unit, final Region region, final String name) {
    if (tile == null || unit == null || region == null)
        return false;
    return askServer().newRegionName(region, tile, unit, name);
}