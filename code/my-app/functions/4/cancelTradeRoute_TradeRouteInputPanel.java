public void cancelTradeRoute() {
    this.newRoute.setName(null);
    getGUI().removeFromCanvas(this);
}