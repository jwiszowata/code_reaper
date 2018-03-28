public String getLocationName(TradeLocation tradeLocation) {
    Colony colony = (Colony) tradeLocation;
    return colony.getName();
}