public void mouseClicked(MouseEvent e) {
    Unit unit = getGUI().getActiveUnit();
    if (unit == null)
        return;
    int x = e.getX() - compassRose.getWidth() / 2;
    int y = e.getY() - compassRose.getHeight() / 2;
    double theta = Math.atan2(y, x) + Math.PI / 2 + Math.PI / 8;
    if (theta < 0) {
        theta += 2 * Math.PI;
    }
    igc().moveUnit(unit, Direction.angleToDirection(theta));
}