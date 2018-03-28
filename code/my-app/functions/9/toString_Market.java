public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId()).append(" owner=").append(owner.getId());
    for (MarketData md : sort(marketData.values())) {
        sb.append(' ').append(md);
    }
    sb.append(']');
    return sb.toString();
}