private void remove(RemoveServerMessage message) {
    final String address = message.getAddress();
    final int port = message.getPort();
    metaRegister.removeServer(address, port);
}