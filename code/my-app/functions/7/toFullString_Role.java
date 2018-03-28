public String toFullString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append("[Role ").append(getSuffix());
    forEachMapEntry(getRequiredAbilities(), e -> sb.append(' ').append(e.getKey()).append('=').append(e.getValue()));
    sb.append(']');
    return sb.toString();
}