private static void setOpaqueLayerRecursive(Component opaqueComponent) {
    if (opaqueComponent instanceof JTextArea || opaqueComponent instanceof JLabel) {
        if (opaqueComponent.isOpaque()) {
            ((JComponent) opaqueComponent).setOpaque(false);
        }
    } else if (opaqueComponent instanceof JPanel) {
        JComponent panel = (JComponent) opaqueComponent;
        if (panel.isOpaque()) {
            panel.setOpaque(false);
        }
        iterateOverOpaqueLayersComponents(panel);
    }
}