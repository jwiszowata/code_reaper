public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    if (null == command)
        return;
    if (command.equals(OK)) {
        final TradeRoute route = getRoute();
        if (this.unit != null && route != null) {
            igc().assignTradeRoute(this.unit, route);
        }
    }
    super.actionPerformed(ae);
}