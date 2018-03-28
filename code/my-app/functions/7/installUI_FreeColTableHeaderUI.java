public void installUI(JComponent c) {
    super.installUI(c);
    JTableHeader j = (JTableHeader) c;
    j.setOpaque(false);
    DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) j.getDefaultRenderer();
    dtcr.setOpaque(false);
}