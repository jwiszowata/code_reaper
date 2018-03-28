public void setPartialChosen(boolean partialChosen) {
    super.setPartialChosen(partialChosen);
    ImageLibrary lib = gui.getImageLibrary();
    Image image = partialChosen ? lib.getSmallIconImage(getType()) : lib.getIconImage(getType());
    setIcon(new ImageIcon(image));
}