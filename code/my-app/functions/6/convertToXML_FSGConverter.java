public void convertToXML(File in, File out) throws FileNotFoundException, IOException {
    try (FileInputStream fis = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out)) {
        convertToXML(fis, fos);
    }
}