public void buildDetail(String id, JPanel panel) {
    if (getId().equals(id))
        return;
    TileType tileType = getSpecification().getTileType(id);
    panel.setLayout(new MigLayout("wrap 4, gap 20"));
    String movementCost = String.valueOf(tileType.getBasicMoveCost() / 3);
    String defenseBonus = Messages.message("none");
    Modifier defenceModifier = first(tileType.getDefenceModifiers());
    if (defenceModifier != null) {
        defenseBonus = ModifierFormat.getModifierAsString(defenceModifier);
    }
    JLabel nameLabel = Utility.localizedHeaderLabel(tileType, FontLibrary.FontSize.SMALL);
    panel.add(nameLabel, "span, align center");
    panel.add(Utility.localizedLabel("colopedia.terrain.terrainImage"), "spany 3");
    Image terrainImage = SwingGUI.createTileImageWithOverlayAndForest(tileType, ImageLibrary.TILE_OVERLAY_SIZE);
    panel.add(new JLabel(new ImageIcon(terrainImage)), "spany 3");
    List<ResourceType> resourceList = tileType.getResourceTypes();
    ResourceType rt = first(resourceList);
    if (rt != null) {
        panel.add(Utility.localizedLabel("colopedia.terrain.resource"));
        if (resourceList.size() > 1) {
            panel.add(getResourceButton(rt), "split " + resourceList.size());
            for (int index = 1; index < resourceList.size(); index++) {
                panel.add(getResourceButton(resourceList.get(index)));
            }
        } else {
            panel.add(getResourceButton(rt));
        }
    } else {
        panel.add(new JLabel(), "wrap");
    }
    panel.add(Utility.localizedLabel("colopedia.terrain.movementCost"));
    panel.add(new JLabel(movementCost));
    panel.add(Utility.localizedLabel("colopedia.terrain.defenseBonus"));
    panel.add(new JLabel(defenseBonus));
    panel.add(Utility.localizedLabel("colopedia.terrain.unattendedProduction"));
    addProduction(panel, tileType.getPossibleProduction(true));
    panel.add(Utility.localizedLabel("colopedia.terrain.colonistProduction"));
    addProduction(panel, tileType.getPossibleProduction(false));
    panel.add(Utility.localizedLabel("colopedia.terrain.description"));
    panel.add(Utility.localizedTextArea(Messages.descriptionKey(tileType)), "span, growx");
}