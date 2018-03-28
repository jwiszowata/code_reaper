public boolean addModifier(Modifier modifier) {
    FeatureContainer fc = getFeatureContainer();
    if (fc == null)
        return false;
    return fc.addModifier(modifier);
}