public ColonyBuilder addColonist(UnitType type) {
    if (!colonists.containsKey(type)) {
        colonists.put(type, 0);
    }
    Integer nCol = colonists.get(type);
    colonists.put(type, nCol + 1);
    return this;
}