private void insertMessage(StyledDocument document, ModelMessage message, Player player) throws BadLocationException {
    for (Object o : message.splitLinks(player)) {
        if (o instanceof String) {
            document.insertString(document.getLength(), (String) o, document.getStyle("regular"));
        } else if (o instanceof JButton) {
            JButton b = (JButton) o;
            b.addActionListener(this);
            StyleConstants.setComponent(document.getStyle("button"), b);
            document.insertString(document.getLength(), " ", document.getStyle("button"));
        }
    }
}