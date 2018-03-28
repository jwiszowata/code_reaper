public void addConnection(Connection connection) {
    if (!this.running)
        return;
    this.connections.put(connection.getSocket(), connection);
}