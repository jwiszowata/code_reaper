public void initialize() {
    if (colony != null) {
        colony.addPropertyChangeListener(EVENT, this);
        if (openBuildQueue) {
            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    ((SwingGUI) freeColClient.getGUI()).showBuildQueuePanel(colony);
                }
            });
        }
    }
    update();
}