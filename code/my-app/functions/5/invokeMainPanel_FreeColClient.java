public Runnable invokeMainPanel(final String userMsg) {
    return () -> SwingUtilities.invokeLater(() -> {
        gui.showMainPanel(userMsg);
    });
}