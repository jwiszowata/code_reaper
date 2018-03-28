public Region getRegionByName(final String name) {
    return (name == null) ? null : find(getRegions(), matchKeyEquals(name, Region::getName));
}