public boolean hasAbility(String id, FreeColSpecObjectType fcgot, Turn turn) {
    return FeatureContainer.hasAbility(getAbilities(id, fcgot, turn));
}