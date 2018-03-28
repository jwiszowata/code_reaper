protected JButton getGoodsButton(final GoodsType goodsType, String text) {
    JButton result = getButton(goodsType, text, new ImageIcon(getImageLibrary().getIconImage(goodsType)));
    result.setToolTipText(Messages.getName(goodsType));
    return result;
}