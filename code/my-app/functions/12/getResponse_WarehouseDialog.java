public Boolean getResponse() {
    Boolean result = super.getResponse();
    if (result) {
        for (Component c : warehousePanel.getComponents()) {
            if (c instanceof WarehouseGoodsPanel) {
                ((WarehouseGoodsPanel) c).saveSettings();
            }
        }
    }
    warehousePanel = null;
    return result;
}