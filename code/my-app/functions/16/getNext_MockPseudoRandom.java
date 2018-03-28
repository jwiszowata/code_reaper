private int getNext() {
    if (pos < setNumberList.size()) {
        int number = setNumberList.get(pos);
        pos++;
        return number;
    }
    if (cycleNumbers && !setNumberList.isEmpty()) {
        int number = setNumberList.get(0);
        pos = 1;
        return number;
    }
    if (random == null) {
        random = new Random(0);
    }
    return -1;
}