private DOMMessage serverList() {
    final ServerListMessage message = new ServerListMessage();
    for (ServerInfo si : metaRegister.getServers()) {
        message.addServer(si);
    }
    return message;
}