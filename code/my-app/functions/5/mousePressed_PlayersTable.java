public void mousePressed(MouseEvent e) {
    int col = header.columnAtPoint(e.getPoint());
    renderer.setPressedColumn(col);
    header.repaint();
}