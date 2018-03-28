private void reloadMainPanel() {
    SwingUtilities.invokeLater(() -> {
        getGUI().closeMainPanel();
        getGUI().showMainPanel(null);
        getSoundController().playSound("sound.intro.general");
    });
}