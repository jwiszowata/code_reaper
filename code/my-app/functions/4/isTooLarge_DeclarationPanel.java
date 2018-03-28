private boolean isTooLarge(String name) {
    Dimension d = faFile.getDimension(name);
    return (d.width > DeclarationPanel.this.getWidth() - 10);
}