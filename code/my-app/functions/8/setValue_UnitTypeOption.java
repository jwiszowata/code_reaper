public void setValue(UnitType value) {
    final UnitType oldValue = this.value;
    this.value = value;
    if (value != oldValue && isDefined) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
    isDefined = true;
}