private JLabel newLabel(String h, ImageIcon i, Color c) {
    JLabel l = new JLabel(h, i, SwingConstants.CENTER);
    l.setForeground((c == null) ? Color.BLACK : c);
    return l;
}