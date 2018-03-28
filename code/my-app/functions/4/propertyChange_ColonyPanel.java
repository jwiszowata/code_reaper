public void propertyChange(PropertyChangeEvent event) {
    super.propertyChange(event);
    ColonyPanel.this.updateProduction();
}