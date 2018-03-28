public int getUpkeep() {
    return sum(getBuildings(), b -> b.getType().getUpkeep());
}