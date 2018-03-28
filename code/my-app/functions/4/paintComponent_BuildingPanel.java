public void paintComponent(Graphics g) {
    ImageLibrary lib = freeColClient.getGUI().getImageLibrary();
    g.drawImage(lib.getBuildingImage(building), 0, 0, this);
}