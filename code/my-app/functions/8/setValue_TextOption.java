public void setValue(String value) {
    final String oldValue = this.value;
    this.value = value;
    if (isDefined && !Utils.equals(value, oldValue)) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
    isDefined = true;
}