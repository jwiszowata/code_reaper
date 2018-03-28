public static void setSubcomponentsNotOpaque(JComponent j) {
    synchronized (j.getTreeLock()) {
        iterateOverOpaqueLayersComponents(j);
    }
}