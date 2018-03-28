public List<Colony> getSortedColonies(Player p) {
    return p.getSortedColonies(getColonyComparator());
}