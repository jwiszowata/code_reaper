public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
    if (pcs == null)
        pcs = new PropertyChangeSupport(this);
    pcs.addPropertyChangeListener(propertyName, listener);
}