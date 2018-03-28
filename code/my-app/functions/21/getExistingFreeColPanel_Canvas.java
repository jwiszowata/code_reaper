private <T extends FreeColPanel> T getExistingFreeColPanel(Class<T> type) {
    for (Component c1 : getComponents()) {
        if (c1 instanceof JInternalFrame) {
            for (Component c2 : ((JInternalFrame) c1).getContentPane().getComponents()) {
                try {
                    T ret = type.cast(c2);
                    if (ret != null) {
                        final JInternalFrame jif = (JInternalFrame) c1;
                        SwingUtilities.invokeLater(() -> {
                            jif.toFront();
                            jif.repaint();
                        });
                        return ret;
                    }
                } catch (ClassCastException cce) {
                }
            }
        }
    }
    return null;
}