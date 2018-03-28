public void addStanceChange(ServerPlayer other) {
    if (!stanceDirty.contains(other))
        stanceDirty.add(other);
}