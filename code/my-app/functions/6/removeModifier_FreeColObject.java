public Modifier removeModifier(Modifier modifier) {
    FeatureContainer fc = getFeatureContainer();
    if (fc == null)
        return null;
    return fc.removeModifier(modifier);
}