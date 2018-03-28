public Stream<Ability> getAbilities(String id, FreeColSpecObjectType fcgot, Turn turn) {
    FeatureContainer fc = getFeatureContainer();
    return (fc == null) ? Stream.<Ability>empty() : fc.getAbilities(id, fcgot, turn);
}