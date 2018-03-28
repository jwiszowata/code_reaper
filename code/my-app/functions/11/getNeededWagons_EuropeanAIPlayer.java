public int getNeededWagons(Tile tile) {
    if (tile != null) {
        int contig = tile.getContiguity();
        if (contig > 0) {
            Integer i = wagonsNeeded.get(contig);
            if (i != null)
                return i;
        }
    }
    return 0;
}