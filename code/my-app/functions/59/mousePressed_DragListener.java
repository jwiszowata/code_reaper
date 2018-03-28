public void mousePressed(MouseEvent e) {
    JComponent comp = (JComponent) e.getSource();
    if (e.getButton() == MouseEvent.BUTTON3 || e.isPopupTrigger()) {
        if (!parentPanel.isEditable()) {
            logger.warning("Button3 disabled on non-editable panel: " + parentPanel);
            return;
        }
        final QuickActionMenu menu = new QuickActionMenu(freeColClient, parentPanel).addMenuItems(comp);
        final int lastIdx = menu.getComponentCount() - 1;
        if ((lastIdx >= 0) && (menu.getComponent(lastIdx) instanceof Separator))
            menu.remove(lastIdx);
        if (menu.getComponentCount() <= 0)
            return;
        final SwingGUI gui = (SwingGUI) freeColClient.getGUI();
        if ((gui.isWindowed() && windows) || (!gui.isWindowed() && small)) {
            menu.show(gui.getCanvas(), menu.getLocation().x, 0);
        } else {
            menu.show(comp, e.getX(), e.getY());
        }
    } else {
        if (comp instanceof AbstractGoodsLabel) {
            AbstractGoodsLabel label = (AbstractGoodsLabel) comp;
            if (e.isShiftDown() && e.isAltDown()) {
                Component[] cArr = comp.getParent().getComponents();
                int sum = 0;
                for (int i = 0; i < cArr.length; i++) {
                    if (cArr[i] instanceof AbstractGoodsLabel) {
                        AbstractGoodsLabel abGoods = (AbstractGoodsLabel) cArr[i];
                        if (abGoods.getAbstractGoods().getType().equals(label.getAbstractGoods().getType())) {
                            sum += abGoods.getAmount();
                        }
                    }
                }
                label.setSuperFullChosen(true);
                label.setAmount(sum);
            } else if (e.isShiftDown()) {
                label.setSuperFullChosen(false);
                label.setPartialChosen(true);
            } else if (e.isControlDown()) {
                label.setSuperFullChosen(false);
                label.setFullChosen(true);
            } else {
                label.setSuperFullChosen(false);
                label.setPartialChosen(false);
                label.setDefaultAmount();
            }
        } else if (comp instanceof UnitLabel) {
            final UnitLabel label = (UnitLabel) comp;
            final Unit u = label.getUnit();
            if (u.isCarrier() && !u.isAtSea() && parentPanel instanceof PortPanel) {
                ((PortPanel) parentPanel).setSelectedUnitLabel(label);
            }
        }
        final TransferHandler handler = comp.getTransferHandler();
        if (handler != null) {
            handler.exportAsDrag(comp, e, TransferHandler.COPY);
        }
    }
}