public static void loadMessages(InputStream is) throws IOException {
    InputStreamReader inputReader;
    try {
        inputReader = new InputStreamReader(is, "UTF-8");
    } catch (UnsupportedEncodingException uee) {
        return;
    }
    BufferedReader in = new BufferedReader(inputReader);
    String line = null;
    while ((line = in.readLine()) != null) {
        line = line.trim();
        int index = line.indexOf('#');
        if (index == 0)
            continue;
        index = line.indexOf('=');
        if (index > 0) {
            String key = line.substring(0, index).trim();
            String value = line.substring(index + 1).trim().replace("\\n", "\n").replace("\\t", "\t");
            messageBundle.put(key, value);
            if (key.startsWith("FileChooser.")) {
                UIManager.put(key, value);
            }
        }
    }
}