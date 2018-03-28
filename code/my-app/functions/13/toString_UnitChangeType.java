public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId()).append(' ').append(getSuffix()).append(" ownerChange=").append(this.ownerChange);
    for (Map.Entry<UnitType, List<UnitChange>> entry : this.changes.entrySet()) {
        sb.append(' ').append(entry.getKey().getSuffix()).append('[');
        for (UnitChange uc : entry.getValue()) {
            sb.append(' ').append(uc);
        }
        sb.append(" ]");
    }
    sb.append(']');
    return sb.toString();
}