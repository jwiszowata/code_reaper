protected Mission lbWait(LogBuilder lb, Object... reasons) {
    lb.add(reasons);
    getUnit().setMovesLeft(0);
    return this;
}