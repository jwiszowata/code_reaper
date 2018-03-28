public void removeNotify() {
    super.removeNotify();
    removeAll();
    cargoPanel = null;
    inPortPanel = null;
    defaultTransferHandler = null;
    pressListener = null;
    selectedUnitLabel = null;
}