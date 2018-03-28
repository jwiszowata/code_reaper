public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final String unitId = getStringAttribute(UNIT_TAG);
    final String roleId = getStringAttribute(ROLE_TAG);
    final String countString = getStringAttribute(COUNT_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (unit.isInEurope()) {
        ;
    } else if (!unit.hasTile()) {
        return serverPlayer.clientError("Unit is not on the map: " + unitId);
    } else if (unit.getSettlement() == null) {
        return serverPlayer.clientError("Unit is not in a settlement: " + unitId);
    }
    Role role = game.getSpecification().getRole(roleId);
    if (role == null) {
        return serverPlayer.clientError("Not a role: " + roleId);
    }
    int count;
    try {
        count = Integer.parseInt(countString);
    } catch (NumberFormatException nfe) {
        return serverPlayer.clientError("Role count is not an integer: " + countString);
    }
    if (count < 0 || count > role.getMaximumCount()) {
        return serverPlayer.clientError("Invalid role count: " + countString);
    }
    return freeColServer.getInGameController().equipForRole(serverPlayer, unit, role, count);
}