public Connection getConnection(Socket socket) {
    return connections.get(socket);
}