public String toFullString() {
    LogBuilder lb = new LogBuilder(64);
    lb.add(this);
    for (Cargo cargo : tCopy()) lb.add("\n  ->", cargo);
    return lb.toString();
}