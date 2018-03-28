public void serverList(ServerListMessage message) {
    this.consumer.accept(message.getServers());
}