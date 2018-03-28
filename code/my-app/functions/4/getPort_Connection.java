public int getPort() {
    Socket socket = getSocket();
    return (socket == null) ? -1 : socket.getPort();
}