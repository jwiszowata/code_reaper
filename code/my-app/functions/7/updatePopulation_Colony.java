public void updatePopulation() {
    updateSoL();
    updateProductionBonus();
    if (getOwner().isAI()) {
        firePropertyChange(Colony.REARRANGE_COLONY, true, false);
    }
}