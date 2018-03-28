private JInternalFrame addAsFrame(JComponent comp, boolean toolBox, PopupPosition popupPosition, boolean resizable) {
    final int FRAME_EMPTY_SPACE = 60;
    final JInternalFrame f = (toolBox) ? new ToolBoxFrame() : new JInternalFrame();
    if (f.getContentPane() instanceof JComponent) {
        JComponent c = (JComponent) f.getContentPane();
        c.setOpaque(false);
        c.setBorder(null);
    }
    if (comp.getBorder() != null) {
        if (comp.getBorder() instanceof EmptyBorder) {
            f.setBorder(Utility.blankBorder(10, 10, 10, 10));
        } else {
            f.setBorder(comp.getBorder());
            comp.setBorder(Utility.blankBorder(5, 5, 5, 5));
        }
    } else {
        f.setBorder(null);
    }
    final FrameMotionListener fml = new FrameMotionListener(f);
    comp.addMouseMotionListener(fml);
    comp.addMouseListener(fml);
    if (f.getUI() instanceof BasicInternalFrameUI) {
        BasicInternalFrameUI biu = (BasicInternalFrameUI) f.getUI();
        biu.setNorthPane(null);
        biu.setSouthPane(null);
        biu.setWestPane(null);
        biu.setEastPane(null);
    }
    f.getContentPane().add(comp);
    f.setOpaque(false);
    f.pack();
    int width = f.getWidth();
    int height = f.getHeight();
    if (width > getWidth() - FRAME_EMPTY_SPACE) {
        width = Math.min(width, getWidth());
    }
    if (height > getHeight() - FRAME_EMPTY_SPACE) {
        height = Math.min(height, getHeight());
    }
    f.setSize(width, height);
    Point p = chooseLocation(comp, width, height, popupPosition);
    f.setLocation(p);
    this.add(f, MODAL_LAYER);
    f.setName(comp.getClass().getSimpleName());
    f.setFrameIcon(null);
    f.setVisible(true);
    f.setResizable(resizable);
    try {
        f.setSelected(true);
    } catch (java.beans.PropertyVetoException e) {
    }
    return f;
}