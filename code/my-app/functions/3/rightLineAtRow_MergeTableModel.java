String rightLineAtRow(int rowIndex) {
    return rowIndex < merge.lineFromFile2.size() ? (String) merge.lineFromFile2.get(rowIndex) : null;
}