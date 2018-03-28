public static ChangeSet clientError(ServerPlayer serverPlayer, String message) {
    See see = (serverPlayer == null) ? See.all() : See.only(serverPlayer);
    return clientError(see, message);
}