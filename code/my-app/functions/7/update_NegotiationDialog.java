public void update(DiplomaticTrade dt) {
    int gold = dt.getGoldGivenBy(source);
    if (gold >= 0) {
        SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
        model.setValue(gold);
    }
}