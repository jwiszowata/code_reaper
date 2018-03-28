public void actionPerformed(ActionEvent ae) {
    Dimension ms = getGUI().showScaleMapSizeDialog();
    if (ms != null) {
        scaleMapTo(ms.width, ms.height);
    }
}