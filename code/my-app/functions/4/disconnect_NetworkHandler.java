private void disconnect(Connection connection) {
    metaServer.removeConnection(connection);
    connection.close();
}