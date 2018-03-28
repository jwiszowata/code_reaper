public ColonyBuilder colonyName(String name) {
    if (name == null) {
        throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
    return this;
}