public Stream<Modifier> getModifiers(String id, FreeColSpecObjectType fcgot, Turn turn) {
    FeatureContainer fc = getFeatureContainer();
    return (fc == null) ? Stream.<Modifier>empty() : fc.getModifiers(id, fcgot, turn);
}