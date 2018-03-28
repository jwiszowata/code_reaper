public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    if (pcs != null) {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }
}