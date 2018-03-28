private void updatePartialChosen(JComponent comp, boolean partial) {
    if (comp instanceof AbstractGoodsLabel) {
        ((AbstractGoodsLabel) comp).setPartialChosen(partial);
    }
}