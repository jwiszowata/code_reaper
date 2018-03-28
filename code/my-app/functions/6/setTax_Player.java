public void setTax(int amount) {
    tax = amount;
    if (recalculateBellsBonus()) {
        for (Colony c : getColonyList()) c.invalidateCache();
    }
}