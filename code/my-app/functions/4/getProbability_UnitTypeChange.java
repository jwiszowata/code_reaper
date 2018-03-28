public final int getProbability(ChangeType type) {
    Integer result = changeTypes.get(type);
    return (result == null) ? 0 : result;
}