private JLabel createUnitLabel(Unit unit) {
    final BufferedImage unitImg = lib.getUnitImage(unit);
    final int width = halfWidth + unitImg.getWidth() / 2;
    final int height = unitImg.getHeight();
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = img.createGraphics();
    final int unitX = (width - unitImg.getWidth()) / 2;
    g.drawImage(unitImg, unitX, 0, null);
    Player player = getMyPlayer();
    String text = Messages.message(unit.getOccupationLabel(player, false));
    g.drawImage(lib.getOccupationIndicatorChip(g, unit, text), 0, 0, null);
    final JLabel label = new JLabel(new ImageIcon(img));
    label.setSize(width, height);
    g.dispose();
    return label;
}