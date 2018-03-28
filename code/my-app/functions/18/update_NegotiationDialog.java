public void update(DiplomaticTrade dt) {
    stanceBox.removeAllItems();
    Stance stance = source.getStance(target);
    if (stance != Stance.WAR) {
        stanceBox.addItem(Stance.WAR);
    } else {
        stanceBox.addItem(Stance.CEASE_FIRE);
    }
    if (stance != Stance.PEACE && stance != Stance.UNCONTACTED) {
        stanceBox.addItem(Stance.PEACE);
    }
    if (stance == Stance.PEACE) {
        stanceBox.addItem(Stance.ALLIANCE);
    }
    Stance select = dt.getStance();
    if (select != null)
        setSelectedValue(select);
}