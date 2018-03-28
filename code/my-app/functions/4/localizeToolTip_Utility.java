public static JComponent localizeToolTip(JComponent comp, StringTemplate template) {
    comp.setToolTipText(Messages.message(template));
    return comp;
}