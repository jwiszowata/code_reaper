public void removeNotify() {
    this.cargoHandler = null;
    this.dragListener = null;
    this.dropListener = null;
    this.stopListModel.clear();
    this.stopListModel = null;
    this.stopList = null;
    this.tradeRouteName = null;
    this.destinationSelector = null;
    this.messagesBox = null;
    this.addStopButton = null;
    this.removeStopButton = null;
    this.cargoPanel = null;
    super.removeNotify();
}