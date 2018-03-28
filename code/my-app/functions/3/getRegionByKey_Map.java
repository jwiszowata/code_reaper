public Region getRegionByKey(final String key) {
    return (key == null) ? null : find(getRegions(), matchKeyEquals(key, Region::getKey));
}