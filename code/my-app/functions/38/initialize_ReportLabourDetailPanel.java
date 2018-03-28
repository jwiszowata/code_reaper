public void initialize() {
    JPanel detailPanel = new MigPanel();
    detailPanel.setLayout(new MigLayout("wrap 7", "[]30[][]30[][]30[][]", ""));
    detailPanel.setOpaque(false);
    detailPanel.add(new JLabel(new ImageIcon(getImageLibrary().getUnitImage(unitType))), "spany");
    detailPanel.add(Utility.localizedLabel(unitType));
    detailPanel.add(new JLabel(String.valueOf(unitCount.getCount(unitType))), "wrap 10");
    boolean canTrain = false;
    Map<Location, Integer> unitLocations = data.get(unitType);
    for (Colony colony : colonies) {
        if (unitLocations.get(colony) != null) {
            String colonyName = colony.getName();
            if (colony.canTrain(unitType)) {
                canTrain = true;
                colonyName += "*";
            }
            JButton colonyButton = Utility.getLinkButton(colonyName, null, colony.getId());
            colonyButton.addActionListener(this);
            detailPanel.add(colonyButton);
            JLabel countLabel = new JLabel(unitLocations.get(colony).toString());
            countLabel.setForeground(Utility.LINK_COLOR);
            detailPanel.add(countLabel);
        }
    }
    forEachMapEntry(unitLocations, e -> !(e.getKey() instanceof Colony), e -> {
        String locationName = Messages.message(e.getKey().getLocationLabel());
        JButton linkButton = Utility.getLinkButton(locationName, null, e.getKey().getId());
        linkButton.addActionListener(this);
        detailPanel.add(linkButton);
        JLabel countLabel = new JLabel(e.getValue().toString());
        countLabel.setForeground(Utility.LINK_COLOR);
        detailPanel.add(countLabel);
    });
    if (canTrain) {
        detailPanel.add(Utility.localizedLabel("report.labour.canTrain"), "newline 20, span");
    }
    reportPanel.add(detailPanel);
}