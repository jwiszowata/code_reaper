public void insertInRight(int from, int to) {
    for (int i = from; i <= to; i++) {
        String line = leftLineAtRow(i);
        line = "@" + line;
        merge.lineFromFile2.add(i, line);
    }
    mergeChanged();
}