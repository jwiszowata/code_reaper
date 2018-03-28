public StringTemplate getReducePopulationMessage() {
    if (canReducePopulation())
        return null;
    Modifier min = first(getModifiers(Modifier.MINIMUM_COLONY_SIZE));
    if (min == null)
        return null;
    FreeColObject source = min.getSource();
    if (source instanceof BuildingType) {
        source = getBuilding((BuildingType) source).getType();
    }
    return StringTemplate.template("model.colony.minimumColonySize").addName("%object%", source);
}