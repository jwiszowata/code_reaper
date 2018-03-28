public void modifyLiberty(int amount) {
    getOwner().modifyLiberty(amount);
    liberty += amount;
    liberty = Math.max(0, liberty);
    updateSoL();
    updateProductionBonus();
    boolean capped = getSpecification().getBoolean(GameOptions.BELL_ACCUMULATION_CAPPED);
    if (capped && sonsOfLiberty >= 100) {
        liberty = LIBERTY_PER_REBEL * getUnitCount();
    }
}