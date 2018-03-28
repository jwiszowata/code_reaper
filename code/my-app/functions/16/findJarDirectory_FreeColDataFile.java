private static String findJarDirectory(File file) {
    String expected = file.getName().substring(0, file.getName().lastIndexOf('.'));
    try (JarFile jf = new JarFile(file)) {
        final JarEntry entry = jf.entries().nextElement();
        final String en = entry.getName();
        final int index = en.lastIndexOf('/');
        String name = "";
        if (index > 0) {
            name = en.substring(0, index + 1);
        }
        return name;
    } catch (Exception e) {
        logger.log(Level.WARNING, "Exception while reading data file.", e);
        return expected;
    }
}