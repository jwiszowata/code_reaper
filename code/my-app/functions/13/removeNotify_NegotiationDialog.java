public void removeNotify() {
    super.removeNotify();
    removeAll();
    this.stancePanel = null;
    this.goldOfferPanel = this.goldDemandPanel = null;
    this.colonyOfferPanel = this.colonyDemandPanel = null;
    this.goodsOfferPanel = this.goodsDemandPanel = null;
    this.inciteOfferPanel = this.inciteDemandPanel = null;
    this.unitOfferPanel = this.unitDemandPanel = null;
    this.summary = null;
    this.demand = this.offer = null;
    this.exchangeMessage = null;
}