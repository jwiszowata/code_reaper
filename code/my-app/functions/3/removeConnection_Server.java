public void removeConnection(Connection connection) {
    this.connections.remove(connection.getSocket());
}