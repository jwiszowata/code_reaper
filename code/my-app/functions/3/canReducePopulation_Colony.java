public boolean canReducePopulation() {
    return getUnitCount() > applyModifiers(0f, getGame().getTurn(), Modifier.MINIMUM_COLONY_SIZE);
}