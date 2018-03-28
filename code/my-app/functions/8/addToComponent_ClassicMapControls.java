public void addToComponent(Canvas component) {
    if (getGame() == null || getGame().getMap() == null)
        return;
    int width = (int) panel.getPreferredSize().getWidth();
    panel.setSize(width, component.getHeight());
    panel.setLocation(component.getWidth() - width, 0);
    component.add(panel, CONTROLS_LAYER);
}