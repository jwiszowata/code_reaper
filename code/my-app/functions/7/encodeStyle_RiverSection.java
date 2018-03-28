public String encodeStyle() {
    StringBuilder sb = new StringBuilder();
    for (Direction direction : Direction.longSides) {
        sb.append(Integer.toString(getBranch(direction), Character.MAX_RADIX));
    }
    return sb.toString();
}