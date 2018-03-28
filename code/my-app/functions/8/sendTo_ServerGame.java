public boolean sendTo(ServerPlayer serverPlayer, ChangeSet cs) {
    try {
        return serverPlayer.send(cs);
    } catch (Exception e) {
        logger.log(Level.WARNING, "sendTo(" + serverPlayer.getId() + "," + cs.toString() + ") failed", e);
    }
    return false;
}