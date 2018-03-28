public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId()).append(" \"").append(this.name).append('"');
    if (this.owner != null)
        sb.append(" owner=").append(this.owner.getId());
    sb.append(" silent=").append(Boolean.toString(this.silent));
    for (TradeRouteStop stop : getStops()) sb.append(' ').append(stop);
    sb.append(']');
    return sb.toString();
}