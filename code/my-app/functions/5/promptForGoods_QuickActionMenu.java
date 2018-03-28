private void promptForGoods(AbstractGoods ag) {
    int ret = gui.showSelectAmountDialog(ag.getType(), GoodsContainer.CARGO_SIZE, ag.getAmount(), true);
    if (ret > 0)
        ag.setAmount(ret);
}