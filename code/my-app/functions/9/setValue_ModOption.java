public void setValue(FreeColModFile value) {
    final FreeColModFile oldValue = this.value;
    this.value = value;
    setId(value.getId());
    if (isDefined && value != oldValue) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
    isDefined = true;
}