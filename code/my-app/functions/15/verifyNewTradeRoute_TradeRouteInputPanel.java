private boolean verifyNewTradeRoute() {
    this.newRoute.setName(tradeRouteName.getText());
    this.newRoute.clearStops();
    for (int index = 0; index < this.stopListModel.getSize(); index++) {
        this.newRoute.addStop(this.stopListModel.get(index));
    }
    this.newRoute.setSilent(this.messagesBox.isSelected());
    StringTemplate err = this.newRoute.verify();
    if (err != null) {
        getGUI().showInformationMessage(err);
        this.newRoute.setName(null);
        return false;
    }
    return true;
}