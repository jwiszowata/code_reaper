public boolean showWarehouseDialog(Colony colony) {
    return showFreeColDialog(new WarehouseDialog(freeColClient, frame, colony), null);
}