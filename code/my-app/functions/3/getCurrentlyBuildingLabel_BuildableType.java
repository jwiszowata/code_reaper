public StringTemplate getCurrentlyBuildingLabel() {
    return StringTemplate.template("model.buildableType.currentlyBuilding").addNamed("%buildable%", this);
}