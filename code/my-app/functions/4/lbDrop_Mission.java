protected Mission lbDrop(LogBuilder lb, Object... reasons) {
    lb.add(", DROPPED", reasons);
    return (aiUnit == null) ? null : aiUnit.changeMission(null);
}