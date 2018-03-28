private void updateSearch(DisplayListOption displayListOption) {
    DefaultListModel<Settlement> model = new DefaultListModel<>();
    Object selected = this.settlementList.getSelectedValue();
    for (Player player : getGame().getLivePlayerList()) {
        boolean ok;
        switch(displayListOption) {
            case ONLY_NATIVES:
                ok = player.isIndian();
                break;
            case ONLY_EUROPEAN:
                ok = player.isEuropean();
                break;
            case ALL:
                ok = true;
                break;
            default:
                ok = false;
                break;
        }
        if (ok) {
            for (Settlement s : player.getSettlementList()) {
                model.addElement(s);
            }
        }
    }
    this.settlementList.setModel(model);
    this.settlementList.setSelectedValue(selected, true);
    if (this.settlementList.getSelectedIndex() < 0) {
        this.settlementList.setSelectedIndex(0);
    }
}