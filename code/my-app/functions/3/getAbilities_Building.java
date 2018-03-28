public Stream<Ability> getAbilities(String id, FreeColSpecObjectType type, Turn turn) {
    return getType().getAbilities(id, type, turn);
}