protected int getCount(String key, UnitType type) {
    TypeCountMap<UnitType> map = units.get(key);
    return (map == null) ? 0 : map.getCount(type);
}