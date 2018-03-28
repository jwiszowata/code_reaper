public static boolean updateServer(ServerInfo si) {
    return metaMessage(MetaMessageType.UPDATE, si, null);
}