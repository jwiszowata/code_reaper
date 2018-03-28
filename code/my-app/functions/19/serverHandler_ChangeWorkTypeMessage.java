public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Specification spec = freeColServer.getSpecification();
    final String unitId = getStringAttribute(UNIT_TAG);
    final String workTypeId = getStringAttribute(WORK_TYPE_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (!unit.hasTile()) {
        return serverPlayer.clientError("Unit is not on the map: " + unitId);
    }
    GoodsType type = spec.getGoodsType(workTypeId);
    if (type == null) {
        return serverPlayer.clientError("Not a goods type: " + workTypeId);
    }
    return freeColServer.getInGameController().changeWorkType(serverPlayer, unit, type);
}