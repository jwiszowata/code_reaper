private static Map<String, String> readFile(File file) {
    Map<String, String> result = new HashMap<>();
    try (Reader reader = Utils.getFileUTF8Reader(file);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
        String line = bufferedReader.readLine();
        while (line != null) {
            int index = line.indexOf('=');
            if (index >= 0) {
                result.put(line.substring(0, index), line.substring(index + 1));
            }
            line = bufferedReader.readLine();
        }
    } catch (Exception e) {
    }
    return result;
}