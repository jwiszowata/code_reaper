public void setValue(Boolean value) {
    final boolean oldValue = this.value;
    this.value = value;
    if (value != oldValue && isDefined) {
        firePropertyChange(VALUE_TAG, oldValue, (boolean) value);
    }
    isDefined = true;
}