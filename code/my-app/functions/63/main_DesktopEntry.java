public static void main(String[] args) throws FileNotFoundException, IOException {
    try (Writer result = Utils.getFileUTF8Writer(new File(args[0]))) {
        result.append("[Desktop Entry]\n");
        result.append("Version=1.0\n");
        result.append("Type=Application\n");
        result.append("Name=FreeCol\n");
        result.append("Exec=freecol\n");
        result.append("Icon=data/freecol.png\n");
        result.append("Categories=Game;StrategyGame;\n");
        String[] sourceFiles = SOURCE_DIRECTORY.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("FreeColMessages") && name.endsWith(".properties");
            }
        });
        for (String name : sourceFiles) {
            System.out.println("Processing source file: " + name);
            String languageCode = null;
            if (name.startsWith("FreeColMessages_")) {
                int index = name.indexOf('.', 16);
                languageCode = name.substring(16, index).replace('-', '@');
            }
            boolean foundGenericName = false;
            boolean foundComment = false;
            File sourceFile = new File(SOURCE_DIRECTORY, name);
            Reader reader = Utils.getFileUTF8Reader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                int index = line.indexOf('=');
                if (index >= 0) {
                    String key = line.substring(0, index).trim();
                    if (null != key)
                        switch(key) {
                            case GENERIC_NAME:
                                result.append("GenericName");
                                foundGenericName = true;
                                break;
                            case COMMENT:
                                result.append("Comment");
                                foundComment = true;
                                break;
                            default:
                                line = bufferedReader.readLine();
                                continue;
                        }
                    if (languageCode != null) {
                        result.append('[' + languageCode + "]");
                    }
                    result.append('=');
                    result.append(line.substring(index + 1).trim());
                    result.append("\n");
                    if (foundGenericName && foundComment) {
                        break;
                    }
                }
                line = bufferedReader.readLine();
            }
        }
        result.flush();
    }
}