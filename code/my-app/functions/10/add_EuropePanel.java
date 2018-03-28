private void add(String text) {
    StyledDocument doc = getStyledDocument();
    try {
        if (doc.getLength() > 0)
            text = "\n\n" + text;
        doc.insertString(doc.getLength(), text, null);
    } catch (Exception e) {
        logger.log(Level.WARNING, "Transaction log update failure", e);
    }
}