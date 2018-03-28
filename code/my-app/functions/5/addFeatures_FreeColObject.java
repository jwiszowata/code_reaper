public void addFeatures(FreeColObject fco) {
    FeatureContainer fc = getFeatureContainer();
    if (fc != null)
        fc.addFeatures(fco);
}