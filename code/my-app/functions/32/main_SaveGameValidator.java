public static void main(String[] args) throws Exception {
    SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
    File schemaLocation = new File("schema/data/data-savedGame.xsd");
    Schema schema = factory.newSchema(schemaLocation);
    Validator saveGameValidator = schema.newValidator();
    List<File> allFiles = new ArrayList<>();
    for (String name : args) {
        File file = new File(name);
        if (file.exists()) {
            if (file.isDirectory()) {
                allFiles.addAll(FreeColDirectories.getSavegameFileList(file));
            } else if (FreeColDirectories.saveGameFilter.test(file)) {
                allFiles.add(file);
            }
        }
    }
    int ret = 0;
    for (File file : allFiles) {
        try {
            FreeColSavegameFile mapFile = new FreeColSavegameFile(file);
            saveGameValidator.validate(new StreamSource(mapFile.getSavegameInputStream()));
            System.out.println("Successfully validated " + file.getName());
        } catch (SAXParseException e) {
            System.out.println(e.getMessage() + " at line=" + e.getLineNumber() + " column=" + e.getColumnNumber());
            ret = Math.max(ret, 1);
        } catch (IOException | SAXException e) {
            System.out.println("Failed to read " + file.getName());
            ret = 2;
        }
    }
    System.exit(ret);
}