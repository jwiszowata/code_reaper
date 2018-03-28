public Colony getColonyByName(String name) {
    return find(getColonies(), matchKeyEquals(name, Colony::getName));
}