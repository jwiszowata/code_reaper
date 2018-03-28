public boolean grew(Object... objects) {
    if (sb == null)
        return false;
    int p = this.points.remove(0);
    if (sb.length() <= p)
        return false;
    StringBuilder sb2 = new StringBuilder(64);
    add(sb2, objects);
    this.sb.insert(p, sb2.toString());
    return true;
}