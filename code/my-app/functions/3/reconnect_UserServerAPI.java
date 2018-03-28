public Connection reconnect() throws IOException {
    return connect(this.name, this.host, this.port);
}