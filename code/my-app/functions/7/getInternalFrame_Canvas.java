private JInternalFrame getInternalFrame(final Component c) {
    Component temp = c;
    while (temp != null && !(temp instanceof JInternalFrame)) {
        temp = temp.getParent();
    }
    return (JInternalFrame) temp;
}