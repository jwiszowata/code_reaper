public OptionGroup showMapGeneratorOptionsDialog(boolean editable) {
    MapGeneratorOptionsDialog mgod = new MapGeneratorOptionsDialog(freeColClient, frame, editable);
    return showFreeColDialog(mgod, null);
}