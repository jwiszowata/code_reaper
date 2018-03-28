public void update() {
    removeAll();
    if (carrier != null) {
        DragListener dl = new DragListener(getFreeColClient(), this);
        for (Unit unit : carrier.getUnitList()) {
            UnitLabel label = new UnitLabel(getFreeColClient(), unit);
            if (isEditable()) {
                label.setTransferHandler(defaultTransferHandler);
                label.addMouseListener(dl);
            }
            add(label);
        }
        for (Goods g : carrier.getGoods()) {
            GoodsLabel label = new GoodsLabel(getGUI(), g);
            if (isEditable()) {
                label.setTransferHandler(defaultTransferHandler);
                label.addMouseListener(dl);
            }
            add(label);
        }
    }
    updateTitle();
    revalidate();
    repaint();
}