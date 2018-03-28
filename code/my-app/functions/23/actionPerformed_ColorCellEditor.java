public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    SwingGUI gui = (SwingGUI) freeColClient.getGUI();
    if (null != command)
        switch(command) {
            case FreeColPanel.OK:
                if (this.colorChooserPanel != null) {
                    this.currentColor = this.colorChooserPanel.getColor();
                    gui.removeFromCanvas(this.colorChooserPanel);
                }
                fireEditingStopped();
                break;
            case FreeColPanel.CANCEL:
                if (this.colorChooserPanel != null) {
                    gui.removeFromCanvas(this.colorChooserPanel);
                }
                fireEditingCanceled();
                break;
            default:
                logger.warning("Bad event: " + command);
                break;
        }
}