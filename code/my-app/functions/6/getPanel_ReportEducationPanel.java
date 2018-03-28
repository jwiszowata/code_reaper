private JPanel getPanel(String key) {
    JPanel result = new JPanel(new FlowLayout(FlowLayout.LEADING));
    result.setOpaque(false);
    result.setBorder(Utility.localizedBorder(key, Color.GRAY));
    return result;
}