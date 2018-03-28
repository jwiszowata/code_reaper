public void mouseClicked(MouseEvent me) {
    JList<GoodsItem> gl = CaptureGoodsDialog.this.goodsList;
    int index = gl.locationToIndex(me.getPoint());
    if (index < 0)
        return;
    GoodsItem item = gl.getModel().getElementAt(index);
    if (item.isEnabled())
        item.setSelected(!item.isSelected());
    updateComponents();
}