public void propertyChange(PropertyChangeEvent event) {
    String property = event.getPropertyName();
    logger.finest(building.getId() + " change " + property + ": " + event.getOldValue() + " -> " + event.getNewValue());
    update();
}