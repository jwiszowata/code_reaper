public void updateMapGeneratorOptions() {
    OptionGroup mgo = getGame().getMapGeneratorOptions();
    askServer().updateMapGeneratorOptions(mgo);
}