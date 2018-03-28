public Stream<Ability> getAbilities(String id, FreeColSpecObjectType fcgot, Turn turn) {
    return getType().getAbilities(id, fcgot, turn);
}