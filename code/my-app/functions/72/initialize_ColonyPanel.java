private void initialize(Colony colony) {
    cleanup();
    setColony(colony);
    addPropertyChangeListeners();
    addMouseListeners();
    setTransferHandlers(isEditable());
    unloadButton.addActionListener(unloadCmd);
    fillButton.addActionListener(fillCmd);
    warehouseButton.addActionListener(warehouseCmd);
    buildQueueButton.addActionListener(buildQueueCmd);
    colonyUnitsButton.addActionListener(colonyUnitsCmd);
    if (setGoodsButton != null) {
        setGoodsButton.addActionListener(setGoodsCmd);
    }
    if (traceWorkButton != null) {
        traceWorkButton.addActionListener(occupationCmd);
    }
    unloadButton.setEnabled(isEditable());
    fillButton.setEnabled(isEditable());
    warehouseButton.setEnabled(isEditable());
    buildQueueButton.setEnabled(isEditable());
    colonyUnitsButton.setEnabled(isEditable());
    if (setGoodsButton != null) {
        setGoodsButton.setEnabled(isEditable());
    }
    if (traceWorkButton != null) {
        traceWorkButton.setEnabled(isEditable());
    }
    final GUI gui = getGUI();
    this.nameBox.setEnabled(isEditable());
    this.nameBox.addActionListener((ActionEvent ae) -> {
        final Colony newColony = (Colony) nameBox.getSelectedItem();
        closeColonyPanel();
        gui.showColonyPanel(newColony, null);
    });
    updateNetProductionPanel();
    buildingsPanel.initialize();
    cargoPanel.initialize();
    constructionPanel.initialize();
    inPortPanel.initialize();
    outsideColonyPanel.initialize();
    populationPanel.initialize();
    tilesPanel.initialize();
    warehousePanel.initialize();
    add(this.nameBox, "height 42:, grow");
    int tmp = (int) (ImageLibrary.ICON_SIZE.height * gui.getImageLibrary().getScaleFactor());
    add(netProductionPanel, "grow, height " + (tmp + 10) + ":" + (2 * tmp + 10) + ":" + (2 * tmp + 10));
    add(tilesScroll, "width 390!, height 200!, top");
    add(buildingsScroll, "span 1 3, grow");
    add(populationPanel, "grow");
    add(constructionPanel, "grow, top");
    add(inPortScroll, "span, split 3, grow, sg, height 60:121:");
    add(cargoScroll, "grow, sg, height 60:121:");
    add(outsideColonyScroll, "grow, sg, height 60:121:");
    add(warehouseScroll, "span, height 40:60:, growx");
    int buttonFields = 6;
    if (setGoodsButton != null)
        buttonFields++;
    if (traceWorkButton != null)
        buttonFields++;
    add(unloadButton, "span, split " + Integer.toString(buttonFields) + ", align center");
    add(fillButton);
    add(warehouseButton);
    add(buildQueueButton);
    add(colonyUnitsButton);
    if (setGoodsButton != null)
        add(setGoodsButton);
    if (traceWorkButton != null)
        add(traceWorkButton);
    add(okButton, "tag ok");
    update();
}