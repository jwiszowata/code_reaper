public static ChangeSet simpleChange(ServerPlayer serverPlayer, DOMMessage message) {
    See see = (serverPlayer == null) ? See.all() : See.only(serverPlayer);
    return simpleChange(see, message);
}