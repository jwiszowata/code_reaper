private void update(UpdateServerMessage message) {
    final ServerInfo si = message.getServerInfo();
    metaRegister.updateServer(si);
}