public void removeAbilities(String id) {
    FeatureContainer fc = getFeatureContainer();
    if (fc != null)
        fc.removeAbilities(id);
}