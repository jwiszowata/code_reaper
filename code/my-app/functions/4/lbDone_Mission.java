protected Mission lbDone(LogBuilder lb, boolean cont, Object... reasons) {
    lb.add(", COMPLETED: ", reasons);
    return (cont) ? aiUnit.getMission() : lbDrop(lb);
}