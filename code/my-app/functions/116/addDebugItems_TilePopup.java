public void addDebugItems(final FreeColClient freeColClient, final Tile tile) {
    addSeparator();
    JMenu changeOwnership = new JMenu("Change ownership");
    changeOwnership.setOpaque(false);
    JMenu transportLists = new JMenu("Transport lists");
    transportLists.setOpaque(false);
    JMenu changeRole = new JMenu("Change role");
    changeRole.setOpaque(false);
    for (final Unit unit : tile.getUnitList()) {
        JMenuItem toMenuItem = new JMenuItem(unit.toString());
        toMenuItem.addActionListener((ActionEvent ae) -> {
            DebugUtils.changeOwnership(freeColClient, unit);
        });
        changeOwnership.add(toMenuItem);
        if (unit.isCarrier()) {
            JMenuItem menuItem = new JMenuItem(unit.toString());
            menuItem.addActionListener((ActionEvent ae) -> {
                DebugUtils.displayMission(freeColClient, unit);
            });
            transportLists.add(menuItem);
        }
        if (unit.isPerson()) {
            JMenuItem roleMenuItem = new JMenuItem(unit.toString());
            roleMenuItem.addActionListener((ActionEvent ae) -> {
                DebugUtils.changeRole(freeColClient, unit);
            });
            changeRole.add(roleMenuItem);
        }
    }
    if (transportLists.getItemCount() > 0)
        add(transportLists);
    if (tile.getColony() != null) {
        if (changeOwnership.getItemCount() > 0) {
            changeOwnership.addSeparator();
        }
        JMenuItem toMenuItem = new JMenuItem(tile.getColony().toString());
        final Colony colony = tile.getColony();
        toMenuItem.addActionListener((ActionEvent ae) -> {
            DebugUtils.changeOwnership(freeColClient, colony);
        });
        changeOwnership.add(toMenuItem);
        JMenuItem displayColonyPlan = new JMenuItem("Display Colony Plan");
        displayColonyPlan.addActionListener((ActionEvent ae) -> {
            DebugUtils.displayColonyPlan(freeColClient, colony);
        });
        add(displayColonyPlan);
        JMenuItem applyDisaster = new JMenuItem("Apply Disaster");
        applyDisaster.addActionListener((ActionEvent ae) -> {
            DebugUtils.applyDisaster(freeColClient, colony);
        });
        add(applyDisaster);
    }
    if (tile.getIndianSettlement() != null) {
        JMenuItem displayGoods = new JMenuItem("Examine Settlement");
        final IndianSettlement is = tile.getIndianSettlement();
        displayGoods.addActionListener((ActionEvent ae) -> {
            DebugUtils.summarizeSettlement(freeColClient, is);
        });
        add(displayGoods);
    }
    if (changeOwnership.getItemCount() > 0)
        add(changeOwnership);
    if (changeRole.getItemCount() > 0)
        add(changeRole);
    if (tile.hasLostCityRumour()) {
        JMenuItem rumourItem = new JMenuItem("Set Lost City Rumour type");
        rumourItem.setOpaque(false);
        rumourItem.addActionListener((ActionEvent ae) -> {
            DebugUtils.setRumourType(freeColClient, tile);
        });
        add(rumourItem);
    }
    JMenuItem addu = new JMenuItem("Add unit");
    addu.setOpaque(false);
    addu.addActionListener((ActionEvent ae) -> {
        DebugUtils.addNewUnitToTile(freeColClient, tile);
    });
    add(addu);
    if (!tile.isEmpty()) {
        JMenuItem adda = new JMenuItem("Reset moves");
        adda.setOpaque(false);
        final List<Unit> tileUnits = tile.getUnitList();
        adda.addActionListener((ActionEvent ae) -> {
            DebugUtils.resetMoves(freeColClient, tileUnits);
        });
        add(adda);
    }
    final Unit activeUnit = gui.getActiveUnit();
    if (activeUnit != null && activeUnit.getTile() != null) {
        JMenuItem menuItem = new JMenuItem("Show search");
        menuItem.addActionListener((ActionEvent ae) -> {
            if (!freeColClient.currentPlayerIsMyPlayer())
                return;
            Tile currTile = activeUnit.getTile();
            if (currTile == tile)
                return;
            final Map map = activeUnit.getGame().getMap();
            LogBuilder lb = new LogBuilder(512);
            PathNode path = map.findPath(activeUnit, activeUnit.getTile(), tile, activeUnit.getCarrier(), null, lb);
            gui.showInformationMessage(lb.toString());
            canvas.setCurrentPath(path);
            gui.refresh();
        });
        add(menuItem);
    }
    Unit unit = find(tile.getUnits(), u -> u.canCarryGoods() && u.hasSpaceLeft());
    if (unit != null) {
        DebugUtils.addGoodsAdditionEntry(freeColClient, unit, this);
    }
    JMenuItem dumpItem = new JMenuItem("Dump tile");
    dumpItem.setOpaque(false);
    dumpItem.addActionListener((ActionEvent ae) -> {
        DebugUtils.dumpTile(freeColClient, tile);
    });
    add(dumpItem);
}