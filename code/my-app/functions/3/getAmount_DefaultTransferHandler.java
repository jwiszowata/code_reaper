private int getAmount(GoodsType goodsType, int available, int defaultAmount, boolean needToPay) {
    return gui.showSelectAmountDialog(goodsType, available, defaultAmount, needToPay);
}