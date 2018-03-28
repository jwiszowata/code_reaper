private void updateDialog() {
    if (this.goldOfferPanel != null) {
        this.goldOfferPanel.update(agreement);
    }
    if (this.stancePanel != null) {
        this.stancePanel.update(agreement);
    }
    if (this.colonyOfferPanel != null) {
        this.colonyOfferPanel.update(agreement);
    }
    if (this.colonyDemandPanel != null) {
        this.colonyDemandPanel.update(agreement);
    }
    if (this.goodsOfferPanel != null) {
        this.goodsOfferPanel.update(agreement);
    }
    if (this.goodsDemandPanel != null) {
        this.goodsDemandPanel.update(agreement);
    }
    if (this.inciteOfferPanel != null) {
        this.inciteOfferPanel.update(agreement);
    }
    if (this.inciteDemandPanel != null) {
        this.inciteDemandPanel.update(agreement);
    }
    if (this.unitOfferPanel != null) {
        this.unitOfferPanel.update(agreement);
    }
    if (this.unitDemandPanel != null) {
        this.unitDemandPanel.update(agreement);
    }
    updateSummary();
}