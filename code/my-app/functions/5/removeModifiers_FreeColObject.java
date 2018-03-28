public void removeModifiers(String id) {
    FeatureContainer fc = getFeatureContainer();
    if (fc != null)
        fc.removeModifiers(id);
}