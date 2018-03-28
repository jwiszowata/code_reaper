public final Limit getLimit(String id) {
    return (limits == null) ? null : limits.get(id);
}