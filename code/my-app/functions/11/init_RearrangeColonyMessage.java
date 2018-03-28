public final void init(Game game, String unitId, String locId, String workId, String roleId, String roleCount) {
    this.unit = game.getFreeColGameObject(unitId, Unit.class);
    this.loc = game.findFreeColLocation(locId);
    this.work = (workId == null || workId.isEmpty()) ? null : game.getSpecification().getGoodsType(workId);
    this.role = game.getSpecification().getRole(roleId);
    try {
        this.roleCount = Integer.parseInt(roleCount);
    } catch (NumberFormatException nfe) {
        this.roleCount = 0;
    }
}