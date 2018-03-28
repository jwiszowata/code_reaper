public void actionPerformed(ActionEvent ae) {
    getGUI().zoomOutMap();
    update();
    getActionManager().getFreeColAction(ZoomInAction.id).update();
}