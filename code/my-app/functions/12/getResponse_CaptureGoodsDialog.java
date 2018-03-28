public List<Goods> getResponse() {
    Object value = getValue();
    List<Goods> gl = new ArrayList<>();
    if (options.get(0).equals(value)) {
        for (int i = 0; i < this.goodsList.getModel().getSize(); i++) {
            GoodsItem gi = this.goodsList.getModel().getElementAt(i);
            if (gi.isSelected())
                gl.add(gi.getGoods());
        }
    }
    return gl;
}