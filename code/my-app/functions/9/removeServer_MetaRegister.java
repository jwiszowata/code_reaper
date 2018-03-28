public synchronized void removeServer(String address, int port) {
    int index = indexOf(address, port);
    if (index >= 0) {
        items.remove(index);
        logger.info("Removing server:" + address + ":" + port);
    } else {
        logger.warning("Trying to remove non-existing server:" + address + ":" + port);
    }
}