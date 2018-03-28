public void showVideoComponent(final Component vp, final MouseListener ml, final KeyListener kl) {
    addMouseListener(ml);
    addKeyListener(kl);
    addCentered(vp, JLayeredPane.PALETTE_LAYER);
}