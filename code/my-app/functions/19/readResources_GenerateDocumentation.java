private static void readResources() {
    System.out.println("Processing source file: resources.properties");
    File sourceFile = new File(RULE_DIRECTORY, "resources.properties");
    try (Reader reader = Utils.getFileUTF8Reader(sourceFile);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
        String line = bufferedReader.readLine();
        while (line != null) {
            int index = line.indexOf('=');
            if (index >= 0) {
                String key = line.substring(0, index).trim();
                String value = line.substring(index + 1).trim();
                resources.put(key, value);
            }
            line = bufferedReader.readLine();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}