private JPanel displayStatsMessage(String title, Map<String, String> stats) {
    JPanel panel = new JPanel();
    panel.setBorder(Utility.localizedBorder(title));
    Box b = new Box(BoxLayout.PAGE_AXIS);
    panel.add(b);
    Map<String, String> memory = new HashMap<>();
    Map<String, String> ai = new HashMap<>();
    for (String k : memoryKeys) {
        memory.put(Messages.message("memoryManager." + k), stats.remove(k));
    }
    for (String k : new ArrayList<>(stats.keySet())) {
        if (k.startsWith("AI")) {
            ai.put(k, stats.remove(k));
        }
    }
    b.add(createStatsTable("Memory", memory));
    b.add(createStatsTable("Game", stats));
    if (ai.isEmpty()) {
        b.add(new JLabel());
    } else {
        b.add(createStatsTable("AI", ai));
    }
    return panel;
}