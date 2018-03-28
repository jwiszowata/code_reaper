public int getTax() {
    try {
        return Integer.parseInt(tax);
    } catch (Exception e) {
        return -1;
    }
}