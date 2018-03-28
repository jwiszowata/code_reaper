public final void update() {
    removeAll();
    final Player player = getMyPlayer();
    final Europe europe = player.getEurope();
    add(question, "span, wrap 20");
    buttons.clear();
    for (UnitType ut : sort(units, priceComparator)) {
        int price = europe.getUnitPrice(ut);
        boolean enable = player.checkGold(price);
        JButton newButton = new JButton();
        newButton.setLayout(new MigLayout("wrap 2", "[60]", "[30][30]"));
        ImageIcon icon = new ImageIcon(getImageLibrary().getSmallUnitImage(ut, !enable));
        JLabel name = Utility.localizedLabel(ut);
        name.setEnabled(enable);
        JLabel gold = Utility.localizedLabel(StringTemplate.template("goldAmount").addAmount("%amount%", price));
        gold.setEnabled(enable);
        newButton.setEnabled(enable);
        newButton.add(new JLabel(icon), "span 1 2");
        newButton.add(name);
        newButton.add(gold);
        newButton.setActionCommand(ut.getId());
        newButton.addActionListener(this);
        buttons.add(newButton);
        add(newButton, "grow");
    }
    add(okButton, "newline 20, span, tag ok");
    setSize(getPreferredSize());
    revalidate();
    shouldEnable = player.checkGold(europe.getUnitPrice(first(units)));
}