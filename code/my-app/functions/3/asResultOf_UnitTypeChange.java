public boolean asResultOf(ChangeType type) {
    return changeTypes.containsKey(type) && changeTypes.get(type) > 0;
}