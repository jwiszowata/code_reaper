protected void incrementCount(String key, UnitType type, int number) {
    TypeCountMap<UnitType> map = units.get(key);
    if (map == null) {
        map = new TypeCountMap<>();
        units.put(key, map);
    }
    map.incrementCount(type, number);
}