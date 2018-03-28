private JButton newButton(String action, String h, ImageIcon i, Color c, StringTemplate t) {
    if (h != null && Messages.containsKey(h))
        h = Messages.message(h);
    JButton b = Utility.getLinkButton(h, i, action);
    b.setForeground((c == null) ? Color.BLACK : c);
    if (t != null)
        Utility.localizeToolTip(b, t);
    b.addActionListener(this);
    return b;
}