private static List<String> loadLinesFromFile(String pathToFile) {
    try {
        List<String> lineList = new ArrayList<>();
        FileInputStream in = new FileInputStream(pathToFile);
        StringBuilder line = new StringBuilder();
        while (true) {
            int data = in.read();
            if (-1 == data) {
                if (0 < line.length()) {
                    lineList.add(line.toString());
                }
                break;
            }
            char c = (char) data;
            if ('\r' == c) {
            }
            if ('\n' == c) {
                lineList.add(line.toString());
                line.setLength(0);
            } else {
                line.append(c);
            }
        }
        in.close();
        return lineList;
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
}