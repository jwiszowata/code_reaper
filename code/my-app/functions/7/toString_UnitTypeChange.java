public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(newUnitType).append(' ').append(Integer.toString(turnsToLearn));
    forEachMapEntry(changeTypes, e -> sb.append(' ').append(tags.get(e.getKey())).append('/').append(e.getValue()));
    sb.append(']');
    return sb.toString();
}