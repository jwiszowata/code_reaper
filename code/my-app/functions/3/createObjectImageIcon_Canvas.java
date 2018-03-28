private ImageIcon createObjectImageIcon(FreeColObject display) {
    return (display == null) ? null : createImageIcon(gui.getImageLibrary().getObjectImage(display, 2f));
}