public void addDummyConnection(Connection connection) {
    if (!this.running)
        return;
    this.connections.put(new Socket(), connection);
}