public static void initStyleContext(Font font) {
    Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    STYLE_CONTEXT = new StyleContext();
    Style regular = STYLE_CONTEXT.addStyle("regular", defaultStyle);
    StyleConstants.setFontFamily(regular, font.getFamily());
    StyleConstants.setFontSize(regular, font.getSize());
    Style buttonStyle = STYLE_CONTEXT.addStyle("button", regular);
    StyleConstants.setForeground(buttonStyle, LINK_COLOR);
    Style right = STYLE_CONTEXT.addStyle("right", regular);
    StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
}