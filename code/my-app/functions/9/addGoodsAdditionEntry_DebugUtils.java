public static void addGoodsAdditionEntry(final FreeColClient fcc, final Unit unit, JPopupMenu menu) {
    JMenuItem addg = new JMenuItem("Add goods");
    addg.setOpaque(false);
    addg.addActionListener((ActionEvent ae) -> {
        DebugUtils.addUnitGoods(fcc, unit);
    });
    addg.setEnabled(true);
    menu.add(addg);
}