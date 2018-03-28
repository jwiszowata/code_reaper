public List<AbstractUnit> getStartingUnits(String key) {
    Map<String, AbstractUnit> result = new HashMap<>();
    Map<String, AbstractUnit> defaultMap = startingUnitMap.get(null);
    Map<String, AbstractUnit> difficultyMap = startingUnitMap.get(key);
    if (defaultMap != null) {
        result.putAll(defaultMap);
    }
    if (difficultyMap != null) {
        result.putAll(difficultyMap);
    }
    return new ArrayList<>(result.values());
}