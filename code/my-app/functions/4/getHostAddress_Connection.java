public String getHostAddress() {
    Socket socket = getSocket();
    return (socket == null) ? "" : socket.getInetAddress().getHostAddress();
}