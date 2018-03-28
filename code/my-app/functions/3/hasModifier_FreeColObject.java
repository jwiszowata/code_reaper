public boolean hasModifier(String id, FreeColSpecObjectType fcgot, Turn turn) {
    return any(getModifiers(id, fcgot, turn));
}