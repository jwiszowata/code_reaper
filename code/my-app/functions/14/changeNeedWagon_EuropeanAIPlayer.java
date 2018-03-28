private void changeNeedWagon(Tile tile, int amount) {
    if (tile == null)
        return;
    int contig = tile.getContiguity();
    if (contig > 0) {
        Integer i = wagonsNeeded.get(contig);
        if (i == null) {
            if (amount == 0)
                wagonsNeeded.put(contig, 0);
        } else {
            wagonsNeeded.put(contig, i + amount);
        }
    }
}