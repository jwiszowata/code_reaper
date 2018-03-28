public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final Specification spec = freeColServer.getSpecification();
    final String locationId = getStringAttribute(LOCATION_TAG);
    final String typeId = getStringAttribute(TYPE_TAG);
    final String carrierId = getStringAttribute(CARRIER_TAG);
    final String amountString = getStringAttribute(AMOUNT_TAG);
    FreeColGameObject fcgo = game.getFreeColGameObject(locationId);
    if (!(fcgo instanceof Location)) {
        return serverPlayer.clientError("Not a location: " + locationId);
    }
    Unit carrier;
    try {
        carrier = serverPlayer.getOurFreeColGameObject(carrierId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (!carrier.canCarryGoods()) {
        return serverPlayer.clientError("Not a goods carrier: " + carrierId);
    } else if (carrier.getTradeLocation() == null) {
        return serverPlayer.clientError("Not at a trade location: " + carrierId);
    }
    GoodsType type = spec.getGoodsType(typeId);
    if (type == null) {
        return serverPlayer.clientError("Not a goods type: " + typeId);
    }
    int amount;
    try {
        amount = Integer.parseInt(amountString);
    } catch (NumberFormatException e) {
        return serverPlayer.clientError("Bad amount: " + amountString);
    }
    if (amount <= 0) {
        return serverPlayer.clientError("Amount must be positive: " + amountString);
    }
    return freeColServer.getInGameController().loadGoods(serverPlayer, (Location) fcgo, type, amount, carrier);
}