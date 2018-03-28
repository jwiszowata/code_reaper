public final void setValue(final Language newValue) {
    final Language oldValue = this.value;
    this.value = newValue;
    if (!newValue.equals(oldValue)) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
}