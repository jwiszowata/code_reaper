private void updateButtons() {
    newRouteButton.setEnabled(true);
    if (this.tradeRoutes.getSelectedIndex() < 0) {
        editRouteButton.setEnabled(false);
        deleteRouteButton.setEnabled(false);
        deassignRouteButton.setEnabled(false);
    } else {
        editRouteButton.setEnabled(true);
        deleteRouteButton.setEnabled(true);
        deassignRouteButton.setEnabled(this.unit != null && this.unit.getTradeRoute() != null);
    }
}