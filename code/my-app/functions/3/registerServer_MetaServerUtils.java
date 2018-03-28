public static boolean registerServer(ServerInfo si) {
    return metaMessage(MetaMessageType.REGISTER, si, null);
}