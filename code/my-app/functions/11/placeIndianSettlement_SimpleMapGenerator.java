private IndianSettlement placeIndianSettlement(Player player, boolean capital, Tile tile, Map map, LogBuilder lb) {
    String name = (capital) ? player.getCapitalName(random) : player.getSettlementName(random);
    UnitType skill = generateSkillForLocation(map, tile, player.getNationType());
    ServerIndianSettlement sis = new ServerIndianSettlement(map.getGame(), player, name, tile, capital, skill, null);
    player.addSettlement(sis);
    lb.add("Generated skill for ", sis.getName(), ": ", sis.getLearnableSkill().getSuffix(), "\n");
    sis.placeSettlement(true);
    sis.addRandomGoods(random);
    sis.addUnits(random);
    return sis;
}