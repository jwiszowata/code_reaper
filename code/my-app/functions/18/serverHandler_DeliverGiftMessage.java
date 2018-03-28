public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(this.unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    IndianSettlement is;
    try {
        is = unit.getAdjacentSettlement(this.settlementId, IndianSettlement.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (this.goods.getLocation() != unit) {
        return serverPlayer.clientError("Gift " + this.goods.getId() + " is not with unit " + this.unitId);
    }
    return freeColServer.getInGameController().deliverGiftToSettlement(serverPlayer, unit, is, goods);
}