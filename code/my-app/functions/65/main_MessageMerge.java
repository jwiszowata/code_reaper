public static void main(String[] args) {
    if (args.length != 2) {
        System.err.println("use: MessageMerge path-to-file-1 path-to-file-2");
        System.exit(1);
    }
    String pathToFile1 = args[0];
    final String pathToFile2 = args[1];
    final MergeTableModel mergeTableModel = new MergeTableModel();
    mergeTableModel.merge = new Merge();
    mergeTableModel.merge.lineFromFile1 = loadLinesFromFile(pathToFile1);
    mergeTableModel.merge.lineFromFile2 = loadLinesFromFile(pathToFile2);
    final JTable mergeTable = new JTable(mergeTableModel);
    mergeTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    mergeTable.setDefaultRenderer(Object.class, new MergeTableCellRenderer());
    Action insertInRightAction = new AbstractAction("insert in right") {

        @Override
        public void actionPerformed(ActionEvent event) {
            int from = mergeTable.getSelectionModel().getMinSelectionIndex();
            int to = mergeTable.getSelectionModel().getMaxSelectionIndex();
            mergeTableModel.insertInRight(from, to);
        }
    };
    Action deleteFromRightAction = new AbstractAction("delete from right") {

        @Override
        public void actionPerformed(ActionEvent event) {
            int from = mergeTable.getSelectionModel().getMinSelectionIndex();
            int to = mergeTable.getSelectionModel().getMaxSelectionIndex();
            mergeTableModel.deleteFromRight(from, to);
        }
    };
    Action saveRightAction = new AbstractAction("save right") {

        @Override
        public void actionPerformed(ActionEvent event) {
            saveLinesToFile(mergeTableModel.merge.lineFromFile2, pathToFile2);
        }
    };
    JPanel controlPanel = new JPanel(new GridLayout(1, 3));
    controlPanel.add(new JButton(insertInRightAction));
    controlPanel.add(new JButton(deleteFromRightAction));
    controlPanel.add(new JButton(saveRightAction));
    JPanel rootPane = new JPanel(new BorderLayout());
    rootPane.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    rootPane.add(new JScrollPane(mergeTable), BorderLayout.CENTER);
    rootPane.add(controlPanel, BorderLayout.SOUTH);
    JFrame frame = new JFrame("MessageMerge");
    frame.getContentPane().add(rootPane);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent event) {
            windowClosing(event);
        }
    });
    frame.pack();
    frame.setVisible(true);
}