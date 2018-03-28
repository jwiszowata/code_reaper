public void addToComponent(Canvas canvas) {
    if (getGame() == null || getGame().getMap() == null)
        return;
    final boolean rose = getClientOptions().getBoolean(ClientOptions.DISPLAY_COMPASS_ROSE);
    final int cw = canvas.getWidth();
    final int ch = canvas.getHeight();
    infoPanel.setLocation(cw - infoPanel.getWidth(), ch - infoPanel.getHeight());
    miniMapPanel.setLocation(0, ch - miniMapPanel.getHeight());
    if (rose) {
        compassRose.setLocation(cw - compassRose.getWidth() - 20, 20);
    }
    if (!unitButtons.isEmpty()) {
        final int SPACE = 5;
        int width = -SPACE, height = 0;
        for (UnitButton ub : unitButtons) {
            height = Math.max(height, ub.getHeight());
            width += SPACE + ub.getWidth();
        }
        int x = miniMapPanel.getWidth() + 1 + (infoPanel.getX() - miniMapPanel.getWidth() - width) / 2;
        int y = ch - height - SPACE;
        for (UnitButton ub : unitButtons) {
            ub.setLocation(x, y);
            x += SPACE + ub.getWidth();
        }
    }
    addToCanvas(canvas, infoPanel);
    addToCanvas(canvas, miniMapPanel);
    if (rose)
        addToCanvas(canvas, compassRose);
    if (!getFreeColClient().isMapEditor()) {
        for (UnitButton button : unitButtons) {
            addToCanvas(canvas, button);
            button.refreshAction();
        }
    }
}