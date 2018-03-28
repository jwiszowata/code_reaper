public static boolean removeServer(ServerInfo si) {
    return metaMessage(MetaMessageType.REMOVE, si, null);
}