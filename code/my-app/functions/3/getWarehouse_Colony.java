public Building getWarehouse() {
    return getWorkLocationWithModifier(Modifier.WAREHOUSE_STORAGE, Building.class);
}