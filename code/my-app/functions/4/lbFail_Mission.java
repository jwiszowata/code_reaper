protected Mission lbFail(LogBuilder lb, boolean cont, Object... reasons) {
    lb.add(", FAILED: ", reasons);
    return (cont) ? aiUnit.getMission() : lbDrop(lb);
}