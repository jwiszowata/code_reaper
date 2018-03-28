public int getValueRank() {
    int rank = 0;
    for (Integer i : getItemValues().keySet()) {
        if (i.compareTo(getValue()) == 0)
            return rank;
        rank++;
    }
    return 0;
}