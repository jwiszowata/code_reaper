public final void setValue(MixerWrapper newValue) {
    final MixerWrapper oldValue = this.value;
    if (newValue == null)
        newValue = DEFAULT_MIXER_WRAPPER;
    this.value = newValue;
    if (!newValue.equals(oldValue)) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
}