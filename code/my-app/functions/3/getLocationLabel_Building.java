public StringTemplate getLocationLabel() {
    return StringTemplate.template("model.building.locationLabel").addNamed("%location%", this);
}