public ColorChooserPanel showColorChooserPanel(ActionListener al) {
    ColorChooserPanel ccp = new ColorChooserPanel(freeColClient, al);
    showFreeColPanel(ccp, null, false);
    return ccp;
}