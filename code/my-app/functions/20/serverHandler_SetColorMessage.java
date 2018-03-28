public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Specification spec = freeColServer.getGame().getSpecification();
    if (serverPlayer != null) {
        Nation nation = getNation(spec);
        if (nation != null) {
            Color color = getColor();
            if (color != null) {
                nation.setColor(color);
                freeColServer.sendToAll(new SetColorMessage(nation, color), serverPlayer);
            } else {
                logger.warning("Invalid color: " + this.toString());
            }
        } else {
            logger.warning("Invalid nation: " + this.toString());
        }
    } else {
        logger.warning("setColor from unknown connection.");
    }
    return null;
}