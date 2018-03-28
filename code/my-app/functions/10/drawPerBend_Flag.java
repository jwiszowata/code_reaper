private void drawPerBend(Graphics2D g, boolean sinister) {
    drawBackground(g);
    int colors = backgroundColors.size();
    GeneralPath path = new GeneralPath();
    path.moveTo(0, HEIGHT);
    path.lineTo(sinister ? WIDTH : 0, 0);
    path.lineTo(WIDTH, HEIGHT);
    g.setColor(backgroundColors.get(1 % colors));
    g.fill(path);
}