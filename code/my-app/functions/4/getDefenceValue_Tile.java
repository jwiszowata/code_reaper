public double getDefenceValue() {
    final TileType type = getType();
    return (type == null) ? 0.0 : applyModifiers(1.0f, null, type.getDefenceModifiers());
}