private static void iterateOverOpaqueLayersComponents(JComponent j) {
    if (j instanceof JPanel || j instanceof JOptionPane) {
        Component[] componentes = j.getComponents();
        for (Component componente : componentes) {
            setOpaqueLayerRecursive(componente);
        }
    }
}