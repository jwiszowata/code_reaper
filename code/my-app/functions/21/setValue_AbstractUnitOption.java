public void setValue(AbstractUnit value) {
    final Specification spec = getSpecification();
    final AbstractUnit oldValue = this.value;
    this.value = value;
    if (value == null) {
        this.unitType = null;
        this.role = null;
        this.number = null;
    } else {
        requireUnitType();
        this.unitType.setValue(value.getType(spec));
        requireRole();
        this.role.setValue(value.getRoleId());
        requireNumber();
        this.number.setValue(value.getNumber());
    }
    if (isDefined && (((value == null) != (oldValue == null)) || (value != null && !value.equals(oldValue)))) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
    isDefined = true;
}