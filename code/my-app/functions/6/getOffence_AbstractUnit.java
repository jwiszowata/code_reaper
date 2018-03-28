public double getOffence(Specification spec) {
    int n = getNumber();
    Role role = getRole(spec);
    UnitType type = spec.getUnitType(getId());
    return n * (type.getOffence() + role.getOffence());
}