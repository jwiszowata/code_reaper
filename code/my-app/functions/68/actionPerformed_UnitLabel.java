public void actionPerformed(ActionEvent ae) {
    final Game game = freeColClient.getGame();
    final Specification spec = game.getSpecification();
    final InGameController igc = freeColClient.getInGameController();
    String[] args = ae.getActionCommand().split("/");
    GoodsType gt;
    switch(Enum.valueOf(UnitAction.class, args[0].toUpperCase(Locale.US))) {
        case ASSIGN:
            igc.assignTeacher(unit, game.getFreeColGameObject(args[1], Unit.class));
            break;
        case WORK_COLONYTILE:
            if (args.length < 3)
                break;
            ColonyTile colonyTile = game.getFreeColGameObject(args[1], ColonyTile.class);
            if (args.length >= 4 && "!".equals(args[3])) {
                if (!igc.claimTile(colonyTile.getWorkTile(), unit.getColony()))
                    break;
            }
            if (colonyTile != unit.getLocation())
                igc.work(unit, colonyTile);
            if ((gt = spec.getGoodsType(args[2])) != null && unit.getWorkType() != gt) {
                igc.changeWorkType(unit, gt);
            }
            break;
        case WORK_BUILDING:
            if (args.length < 3)
                break;
            Building building = game.getFreeColGameObject(args[1], Building.class);
            if (building != unit.getLocation())
                igc.work(unit, building);
            if ((gt = spec.getGoodsType(args[2])) != null && unit.getWorkType() != gt) {
                igc.changeWorkType(unit, gt);
            }
            break;
        case ACTIVATE_UNIT:
            igc.changeState(unit, UnitState.ACTIVE);
            gui.setActiveUnit(unit);
            break;
        case FORTIFY:
            igc.changeState(unit, UnitState.FORTIFYING);
            break;
        case SENTRY:
            igc.changeState(unit, UnitState.SENTRY);
            break;
        case COLOPEDIA:
            gui.showColopediaPanel(unit.getType().getId());
            break;
        case LEAVE_TOWN:
            igc.putOutsideColony(unit);
            break;
        case CLEAR_SPECIALITY:
            igc.clearSpeciality(unit);
            break;
        case CLEAR_ORDERS:
            igc.clearOrders(unit);
            break;
        case ASSIGN_TRADE_ROUTE:
            gui.showTradeRoutePanel(unit);
            break;
        case LEAVE_SHIP:
            igc.leaveShip(unit);
            break;
        case UNLOAD:
            igc.unload(unit);
            break;
    }
    updateIcon();
}