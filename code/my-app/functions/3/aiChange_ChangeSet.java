public static ChangeSet aiChange(ServerPlayer serverPlayer, boolean ai) {
    return simpleChange(See.all(), new SetAIMessage(serverPlayer, ai));
}