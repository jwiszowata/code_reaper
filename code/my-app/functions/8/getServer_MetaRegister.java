private ServerInfo getServer(String address, int port) {
    int index = indexOf(address, port);
    if (index >= 0) {
        return items.get(index);
    } else {
        return null;
    }
}