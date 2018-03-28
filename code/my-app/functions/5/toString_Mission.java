public String toString() {
    LogBuilder lb = new LogBuilder(64);
    lb.add(lastPart(getClass().getName(), "."), "@", hashCode(), "-", aiUnit.getUnit(), "->", getTarget());
    return lb.toString();
}