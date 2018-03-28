public void actionPerformed(ActionEvent ae) {
    getGUI().zoomInMap();
    update();
    getActionManager().getFreeColAction(ZoomOutAction.id).update();
}