public void buildDetail(String id, JPanel panel) {
    if (getId().equals(id))
        return;
    Nation nation = getSpecification().getNation(id);
    Player player = CollectionUtils.find(getGame().getLivePlayers(), p -> p.getNation() == nation);
    NationType currentNationType = (player == null) ? nation.getType() : player.getNationType();
    panel.setLayout(new MigLayout("wrap 3, fillx, gapx 20", "", ""));
    JLabel name = Utility.localizedHeaderLabel(nation, FontLibrary.FontSize.SMALL);
    panel.add(name, "span, align center, wrap 40");
    JLabel artLabel = new JLabel(new ImageIcon(ImageLibrary.getMonarchImage(nation)));
    panel.add(artLabel, "spany, gap 40, top");
    panel.add(Utility.localizedLabel("colopedia.nation.ruler"));
    panel.add(new JLabel(nation.getRulerName()));
    panel.add(Utility.localizedLabel("colopedia.nation.defaultAdvantage"));
    panel.add(getButton(nation.getType()));
    panel.add(Utility.localizedLabel("colopedia.nation.currentAdvantage"));
    panel.add(getButton(currentNationType), "wrap push");
}