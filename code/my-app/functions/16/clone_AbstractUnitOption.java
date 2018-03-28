public AbstractUnitOption clone() {
    final Specification spec = getSpecification();
    AbstractUnitOption result = new AbstractUnitOption(getId(), spec);
    result.setValues(this);
    if (value != null) {
        AbstractUnit au = new AbstractUnit(value.getType(spec), value.getRoleId(), value.getNumber());
        result.setValue(au);
    }
    if (unitType != null)
        result.unitType = unitType;
    if (role != null)
        result.role = role;
    if (number != null)
        result.number = number;
    return result;
}