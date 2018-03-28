private void addLimit(Limit limit) {
    if (limits == null)
        limits = new HashMap<>();
    limits.put(limit.getId(), limit);
}