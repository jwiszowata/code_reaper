public boolean updateMapGeneratorOptions(OptionGroup mapOptions) {
    return send(new UpdateMapGeneratorOptionsMessage(mapOptions));
}