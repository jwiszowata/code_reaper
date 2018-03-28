public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("[Scope ").append(type);
    if (abilityId != null) {
        sb.append(' ').append(abilityId).append('=').append(abilityValue);
    }
    if (methodName != null) {
        sb.append(' ').append(methodName).append('=').append(methodValue);
    }
    if (matchesNull)
        sb.append(" matches-null");
    if (matchNegated)
        sb.append(" match-negated");
    sb.append(']');
    return sb.toString();
}