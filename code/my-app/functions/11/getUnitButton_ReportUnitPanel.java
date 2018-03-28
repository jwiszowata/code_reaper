protected JButton getUnitButton(Unit unit) {
    ImageIcon icon = new ImageIcon(getImageLibrary().getUnitImage(unit));
    JButton button = Utility.getLinkButton("", icon, unit.getLocation().getId());
    button.addActionListener(this);
    StringTemplate tip = StringTemplate.label("\n").addStringTemplate(unit.getLabel());
    if (unit.getDestination() != null) {
        tip.addStringTemplate(unit.getDestinationLabel());
    }
    Utility.localizeToolTip(button, tip);
    return button;
}