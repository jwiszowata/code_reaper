public StringTemplate getSimpleLabel() {
    return StringTemplate.template("model.tile.simpleLabel").addAmount("%x%", getX()).addAmount("%y%", getY());
}