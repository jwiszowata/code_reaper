private static Socket createSocket(String host, int port) throws IOException {
    Socket socket = new Socket();
    SocketAddress addr = new InetSocketAddress(host, port);
    socket.connect(addr, TIMEOUT);
    return socket;
}