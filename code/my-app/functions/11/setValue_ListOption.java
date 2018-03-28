public void setValue(List<AbstractOption<T>> value) {
    if (value == null)
        throw new IllegalArgumentException("Null ListOption");
    List<AbstractOption<T>> oldValue = new ArrayList<>(this.value);
    this.value.clear();
    for (AbstractOption<T> op : value) addMember(op);
    if (isDefined && !value.equals(oldValue)) {
        firePropertyChange(VALUE_TAG, oldValue, value);
    }
    isDefined = true;
}