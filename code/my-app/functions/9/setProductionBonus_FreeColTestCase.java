public void setProductionBonus(Colony colony, int value) {
    try {
        Field productionBonus = Colony.class.getDeclaredField("productionBonus");
        productionBonus.setAccessible(true);
        productionBonus.setInt(colony, value);
        colony.invalidateCache();
    } catch (Exception e) {
    }
}