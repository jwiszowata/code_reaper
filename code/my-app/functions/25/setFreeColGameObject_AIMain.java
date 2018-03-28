public void setFreeColGameObject(String id, FreeColGameObject fcgo) {
    if (getAIObject(id) != null || !shouldHaveAIObject(fcgo))
        return;
    if (!id.equals(fcgo.getId())) {
        throw new IllegalArgumentException("!id.equals(fcgo.getId())");
    }
    if (fcgo instanceof Colony) {
        new AIColony(this, (Colony) fcgo);
    } else if (fcgo instanceof ServerPlayer) {
        ServerPlayer player = (ServerPlayer) fcgo;
        if (player.getPlayerType() == null) {
            logger.info("Temporarily ignoring incomplete AI player: " + fcgo.getId());
        } else if (player.isIndian()) {
            new NativeAIPlayer(this, player);
        } else if (player.isREF()) {
            new REFAIPlayer(this, player);
        } else if (player.isEuropean()) {
            new EuropeanAIPlayer(this, player);
        } else {
            throw new IllegalArgumentException("Bogus player: " + player);
        }
    } else if (fcgo instanceof Unit) {
        new AIUnit(this, (Unit) fcgo);
    }
}