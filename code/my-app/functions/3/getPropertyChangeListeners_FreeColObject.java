public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
    return (pcs == null) ? new PropertyChangeListener[0] : pcs.getPropertyChangeListeners(propertyName);
}