public void actionPerformed(ActionEvent ae) {
    GUI gui = getGUI();
    if (gui == null)
        return;
    gui.changeWindowedMode();
}