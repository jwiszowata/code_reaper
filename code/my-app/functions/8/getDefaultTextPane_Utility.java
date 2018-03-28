public static JTextPane getDefaultTextPane() {
    DefaultStyledDocument document = new DefaultStyledDocument(STYLE_CONTEXT);
    JTextPane textPane = new JTextPane(document);
    textPane.setOpaque(false);
    textPane.setEditable(false);
    textPane.setLogicalStyle(STYLE_CONTEXT.getStyle("regular"));
    return textPane;
}