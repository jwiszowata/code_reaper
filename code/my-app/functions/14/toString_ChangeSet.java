public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append((type == ALL) ? "ALL" : (type == PERHAPS) ? "PERHAPS" : (type == ONLY) ? "ONLY" : "BADTYPE");
    if (seeAlways != null) {
        sb.append(",always(").append(seeAlways.getId()).append(')');
    }
    if (seePerhaps != null) {
        sb.append(",perhaps(").append(seePerhaps.getId()).append(')');
    }
    if (seeNever != null) {
        sb.append(",never(").append(seeNever.getId()).append(')');
    }
    return sb.toString();
}