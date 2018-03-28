public void deleteFromRight(int from, int to) {
    for (int i = to; from <= i; i--) {
        merge.lineFromFile2.remove(i);
    }
    mergeChanged();
}