public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (OK.equals(command)) {
        super.actionPerformed(ae);
    } else {
        try {
            int index = Integer.parseInt(command);
            if (Europe.MigrationType.validMigrantIndex(index)) {
                igc().recruitUnitInEurope(index);
                getGUI().updateEuropeanSubpanels();
                if (!shouldEnable)
                    getGUI().removeFromCanvas(this);
                return;
            }
        } catch (NumberFormatException e) {
        }
        logger.warning("Invalid action command: " + command);
    }
}