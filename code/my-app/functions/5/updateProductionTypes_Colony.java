public void updateProductionTypes() {
    for (WorkLocation wl : getAvailableWorkLocationsList()) {
        wl.updateProductionType();
    }
}