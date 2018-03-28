private void register(RegisterServerMessage message) {
    final ServerInfo si = message.getServerInfo();
    metaRegister.addServer(si);
}