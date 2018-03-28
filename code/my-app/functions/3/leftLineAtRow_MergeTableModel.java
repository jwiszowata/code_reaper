String leftLineAtRow(int rowIndex) {
    return rowIndex < merge.lineFromFile1.size() ? (String) merge.lineFromFile1.get(rowIndex) : null;
}