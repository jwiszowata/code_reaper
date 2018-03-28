private JLabel createNumberLabel(int number, String toolTipKey) {
    JLabel label = new JLabel(String.valueOf(number));
    label.setHorizontalAlignment(SwingConstants.TRAILING);
    label.setBorder(Utility.CELLBORDER);
    if (toolTipKey != null)
        Utility.localizeToolTip(this, toolTipKey);
    return label;
}