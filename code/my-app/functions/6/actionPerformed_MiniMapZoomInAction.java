public void actionPerformed(ActionEvent ae) {
    getGUI().zoomInMapControls();
    update();
    getActionManager().getFreeColAction(MiniMapZoomOutAction.id).update();
    getActionManager().getFreeColAction(MiniMapZoomOutAction.id + ".secondary").update();
}