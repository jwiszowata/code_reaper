public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId()).append(' ').append(getLocation().getId());
    for (GoodsType goodsType : getCargo()) {
        sb.append(' ').append(goodsType);
    }
    sb.append(']');
    return sb.toString();
}