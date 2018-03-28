public void actionPerformed(ActionEvent ae) {
    getGUI().zoomOutMapControls();
    update();
    getActionManager().getFreeColAction(MiniMapZoomInAction.id).update();
    getActionManager().getFreeColAction(MiniMapZoomInAction.id + ".secondary").update();
}