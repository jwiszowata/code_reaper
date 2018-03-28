public final String getSuffix() {
    String id = getId();
    return (id == null) ? null : lastPart(id, ".");
}