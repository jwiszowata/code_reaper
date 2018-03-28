private int indexOf(String address, int port) {
    for (int i = 0; i < items.size(); i++) {
        if (address.equals(items.get(i).getAddress()) && port == items.get(i).getPort()) {
            return i;
        }
    }
    return -1;
}