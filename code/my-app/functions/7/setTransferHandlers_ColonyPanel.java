private void setTransferHandlers(boolean enable) {
    DefaultTransferHandler dth = (enable) ? defaultTransferHandler : null;
    cargoPanel.setTransferHandler(dth);
    inPortPanel.setTransferHandler(dth);
    outsideColonyPanel.setTransferHandler(dth);
    warehousePanel.setTransferHandler(dth);
}