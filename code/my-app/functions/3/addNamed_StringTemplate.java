public <T extends StringTemplate> T addNamed(Named named) {
    return add(named.getNameKey());
}