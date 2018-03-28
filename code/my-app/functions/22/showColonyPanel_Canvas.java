public ColonyPanel showColonyPanel(Colony colony, Unit unit) {
    if (colony == null)
        return null;
    ColonyPanel panel = getColonyPanel(colony);
    if (panel == null) {
        try {
            panel = new ColonyPanel(freeColClient, colony);
        } catch (Exception e) {
            try {
                logger.log(Level.WARNING, "Exception in ColonyPanel for " + colony.getId(), e);
            } finally {
                return null;
            }
        }
        showFreeColPanel(panel, colony.getTile(), true);
    } else {
        panel.requestFocus();
    }
    if (unit != null)
        panel.setSelectedUnit(unit);
    return panel;
}