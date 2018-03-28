private JPanel createStatsTable(String title, Map<String, String> data) {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(new JLabel(title), BorderLayout.PAGE_START);
    StatisticsModel model = new StatisticsModel();
    model.setData(data);
    JTable table = new JTable(model);
    table.setAutoCreateColumnsFromModel(true);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    table.setAutoCreateRowSorter(true);
    JScrollPane scrollPane = new JScrollPane(table);
    table.addNotify();
    scrollPane.getViewport().setOpaque(false);
    scrollPane.getColumnHeader().setOpaque(false);
    panel.add(scrollPane, BorderLayout.CENTER);
    panel.setPreferredSize(new Dimension(300, (data.size() + 2) * 17));
    return panel;
}