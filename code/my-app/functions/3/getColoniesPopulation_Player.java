public int getColoniesPopulation() {
    return sum(getColonies(), Colony::getUnitCount);
}