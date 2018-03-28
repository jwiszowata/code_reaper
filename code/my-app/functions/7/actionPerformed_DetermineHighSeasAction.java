public void actionPerformed(ActionEvent ae) {
    final Map map = getGame().getMap();
    Parameters p = getGUI().showParametersDialog();
    if (p != null) {
        map.resetHighSeas(p.distToLandFromHighSeas, p.maxDistanceToEdge);
    }
}