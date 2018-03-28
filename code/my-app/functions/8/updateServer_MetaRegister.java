public synchronized void updateServer(ServerInfo newSi) {
    ServerInfo si = getServer(newSi.getAddress(), newSi.getPort());
    if (si == null) {
        addServer(newSi);
    } else {
        si.update(newSi);
    }
}