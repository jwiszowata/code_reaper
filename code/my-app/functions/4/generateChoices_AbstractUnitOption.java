public void generateChoices() {
    unitType.generateChoices();
    role.setChoices(transform(getSpecification().getRoles(), alwaysTrue(), Role::getId));
}