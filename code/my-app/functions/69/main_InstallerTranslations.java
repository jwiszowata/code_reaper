public static void main(String[] args) throws Exception {
    if (!MAIN_FILE.exists()) {
        System.out.println("Main input file not found.");
        System.exit(1);
    }
    if (!DESTINATION_DIRECTORY.exists()) {
        DESTINATION_DIRECTORY.mkdirs();
    }
    Map<String, String> languageMappings = new HashMap<>();
    for (String[] mapping : IZPACK_CODES) {
        languageMappings.put(mapping[0], mapping[1]);
    }
    Map<String, String> mainProperties = readFile(MAIN_FILE);
    String[] sourceFiles = SOURCE_DIRECTORY.list(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            return name.matches("FreeColMessages_.*\\.properties");
        }
    });
    for (String name : sourceFiles) {
        String languageCode = null;
        int index = name.indexOf('.', 16);
        if (index < 0) {
            continue;
        } else {
            languageCode = languageMappings.get(name.substring(16, index));
            if (languageCode == null) {
                index = name.indexOf('_', 16);
                if (index < 0) {
                    continue;
                } else {
                    languageCode = languageMappings.get(name.substring(16, index));
                }
            }
        }
        if (languageCode == null) {
            System.out.println("Skipping source file: " + name);
            continue;
        }
        System.out.println("Processing source file: " + name);
        File sourceFile = new File(SOURCE_DIRECTORY, name);
        Map<String, String> sourceProperties = readFile(sourceFile);
        StringBuilder output = new StringBuilder();
        output.append("<?xml version = '1.0' encoding = 'UTF-8' standalone = 'yes'?>\n");
        output.append("<!-- ATTENTION: Do not modify this file directly,\n");
        output.append("     modify the source file\n         ");
        output.append(sourceFile.getPath());
        output.append("\n     instead. -->\n");
        output.append("<langpack>\n");
        for (String key : KEYS) {
            String longKey = "installer." + key;
            String value = sourceProperties.get(longKey);
            if (value == null) {
                value = mainProperties.get(longKey);
            }
            output.append("    <str id=\"");
            output.append(key);
            output.append("\" txt=\"");
            output.append(value);
            output.append("\" />\n");
        }
        output.append("</langpack>\n");
        File destinationFile = new File(DESTINATION_DIRECTORY, "lang.xml_" + languageCode);
        try (Writer out = Utils.getFileUTF8Writer(destinationFile)) {
            out.write(output.toString());
        }
    }
}