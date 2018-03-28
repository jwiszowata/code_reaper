public StringTemplate getLabel() {
    return (buildingType == null) ? null : StringTemplate.key(buildingType);
}