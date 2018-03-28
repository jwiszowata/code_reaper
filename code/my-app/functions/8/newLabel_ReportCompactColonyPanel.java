private JLabel newLabel(String h, ImageIcon i, Color c, StringTemplate t) {
    if (h != null && Messages.containsKey(h))
        h = Messages.message(h);
    JLabel l = newLabel(h, i, c);
    if (t != null)
        Utility.localizeToolTip(l, t);
    return l;
}