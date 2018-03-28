public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("[Modifier ").append(getId());
    if (getSource() != null) {
        sb.append(" (" + getSource().getId() + ")");
    }
    sb.append(' ').append(modifierType).append(' ').append(value);
    if (modifierIndex >= DEFAULT_MODIFIER_INDEX) {
        sb.append(" index=").append(modifierIndex);
    }
    List<Scope> scopes = getScopeList();
    if (!scopes.isEmpty()) {
        sb.append(" [");
        for (Scope s : scopes) sb.append(' ').append(s);
        sb.append(" ]");
    }
    sb.append(']');
    return sb.toString();
}