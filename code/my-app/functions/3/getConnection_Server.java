public Connection getConnection(Socket socket) {
    return this.connections.get(socket);
}