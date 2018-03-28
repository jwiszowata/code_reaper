public List<BuildableType> getQueue(Specification spec) {
    return transform(getArrayAttributes(), alwaysTrue(), id -> spec.getType(id, BuildableType.class), toListNoNulls());
}