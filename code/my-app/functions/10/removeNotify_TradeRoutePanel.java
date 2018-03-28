public void removeNotify() {
    this.listModel.clear();
    this.tradeRoutes = null;
    this.counts.clear();
    this.newRouteButton = null;
    this.editRouteButton = null;
    this.deleteRouteButton = null;
    this.deassignRouteButton = null;
    super.removeNotify();
}