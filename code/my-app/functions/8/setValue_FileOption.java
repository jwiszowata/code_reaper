public void setValue(File value) {
    final File oldValue = this.value;
    this.value = value;
    if (value != oldValue) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
    isDefined = true;
}