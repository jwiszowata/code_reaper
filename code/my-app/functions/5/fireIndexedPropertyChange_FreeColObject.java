public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue) {
    if (pcs != null) {
        pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
    }
}