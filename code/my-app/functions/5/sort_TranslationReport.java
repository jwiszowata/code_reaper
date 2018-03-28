private static TreeSet<String> sort(ArrayList<String> missingKeys) {
    TreeSet<String> sorted = new TreeSet<>();
    sorted.addAll(missingKeys);
    return sorted;
}