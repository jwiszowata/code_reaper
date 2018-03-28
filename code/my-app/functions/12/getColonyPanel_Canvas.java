private ColonyPanel getColonyPanel(Colony colony) {
    for (Component c1 : getComponents()) {
        if (c1 instanceof JInternalFrame) {
            for (Component c2 : ((JInternalFrame) c1).getContentPane().getComponents()) {
                if (c2 instanceof ColonyPanel && ((ColonyPanel) c2).getColony() == colony) {
                    return (ColonyPanel) c2;
                }
            }
        }
    }
    return null;
}