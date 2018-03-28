public String fullPathToString() {
    LogBuilder lb = new LogBuilder(500);
    PathNode p;
    for (p = this; p != null; p = p.next) lb.add(p, "\n");
    return lb.toString();
}