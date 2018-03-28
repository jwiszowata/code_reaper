public List<Consumer> getConsumers() {
    List<Consumer> result = new ArrayList<>();
    result.addAll(getUnitList());
    result.addAll(getBuildings());
    result.add(buildQueue);
    result.add(populationQueue);
    result.sort(Consumer.COMPARATOR);
    return result;
}