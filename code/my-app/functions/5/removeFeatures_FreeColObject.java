public void removeFeatures(FreeColObject fco) {
    FeatureContainer fc = getFeatureContainer();
    if (fc != null)
        fc.removeFeatures(fco);
}