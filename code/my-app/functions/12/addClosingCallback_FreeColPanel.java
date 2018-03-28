public void addClosingCallback(final Runnable runnable) {
    addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            if ("closing".equals(e.getPropertyName())) {
                runnable.run();
                FreeColPanel.this.removePropertyChangeListener(this);
            }
        }
    });
}