public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final NativeTrade nt = getNativeTrade();
    if (nt == null) {
        return serverPlayer.clientError("Null native trade");
    }
    final Unit unit = nt.getUnit();
    if (unit == null) {
        return serverPlayer.clientError("Null unit");
    }
    if (!unit.hasTile()) {
        return serverPlayer.clientError("Unit not on the map: " + unit.getId());
    }
    final IndianSettlement is = nt.getIndianSettlement();
    if (is == null) {
        return serverPlayer.clientError("Null settlement");
    }
    if (!unit.getTile().isAdjacent(is.getTile())) {
        return serverPlayer.clientError("Unit not adjacent to settlement");
    }
    return freeColServer.getInGameController().nativeTrade(serverPlayer, getAction(), nt);
}