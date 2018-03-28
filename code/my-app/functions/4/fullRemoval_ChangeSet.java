private boolean fullRemoval(ServerPlayer serverPlayer) {
    FreeColGameObject fcgo = getMainObject();
    return fcgo instanceof Ownable && serverPlayer.owns((Ownable) fcgo);
}