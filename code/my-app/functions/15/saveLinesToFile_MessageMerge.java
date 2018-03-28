private static void saveLinesToFile(List<String> lineList, String pathToFile) {
    try {
        FileOutputStream out = new FileOutputStream(pathToFile);
        for (int lineNumber = 0, lines = lineList.size(); lineNumber < lines; lineNumber++) {
            String line = (String) lineList.get(lineNumber);
            for (int i = 0; i < line.length(); i++) {
                out.write(line.charAt(i));
            }
            out.write('\n');
        }
        out.close();
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
}