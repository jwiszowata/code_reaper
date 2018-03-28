public IndianSettlement getResponse() {
    final Specification spec = freeColClient.getGame().getSpecification();
    final SwingGUI gui = getGUI();
    IndianSettlement ret = null;
    Set<Tile> tiles = is.getOwnedTiles();
    Object value = getValue();
    if (options.get(0).equals(value)) {
        is.setName(this.name.getText());
        Nation newNation = getOwnerNation();
        if (newNation != is.getOwner().getNation()) {
            Player newPlayer = getOwnerPlayer();
            is.setOwner(newPlayer);
            for (Unit u : is.getAllUnitsList()) {
                u.setOwner(newPlayer);
                u.setEthnicity(newNation.getId());
                u.setNationality(newNation.getId());
            }
            for (Tile t : is.getOwnedTiles()) {
                t.setOwner(newPlayer);
            }
            MapEditorTransformPanel.setNativeNation(newNation);
        }
        if (this.capital.isSelected() && !is.isCapital()) {
            for (IndianSettlement indianSettlement : is.getOwner().getIndianSettlementList()) {
                indianSettlement.setCapital(false);
            }
            is.setCapital(true);
        } else if (!this.capital.isSelected() && is.isCapital()) {
            is.setCapital(false);
        }
        is.setLearnableSkill((UnitType) this.skill.getSelectedItem());
        int numberOfUnits = (Integer) this.units.getValue() - is.getUnitCount();
        if (numberOfUnits > 0) {
            Player owner = is.getOwner();
            UnitType brave = spec.getDefaultUnitType(owner);
            for (int index = 0; index < numberOfUnits; index++) {
                is.add(new ServerUnit(is.getGame(), is, owner, brave));
            }
        } else if (numberOfUnits < 0) {
            List<Unit> unitList = is.getUnitList().subList(0, -numberOfUnits);
            for (Unit unit : unitList) {
                unit.dispose();
            }
        }
        SettlementType oldType = is.getType();
        SettlementType type = getSettlementType();
        is.setType(type);
        is.getFeatureContainer().replaceSource(oldType, type);
        ret = is;
    } else if (options.get(1).equals(value)) {
        if (!gui.confirm("editSettlementDialog.removeSettlement.text", "ok", "cancel")) {
            return is;
        }
        Tile tile = is.getTile();
        for (Unit unit : tile.getUnitList()) unit.dispose();
        is.exciseSettlement();
    }
    for (Tile t : tiles) gui.refreshTile(t);
    return ret;
}