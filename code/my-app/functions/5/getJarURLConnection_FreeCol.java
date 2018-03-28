private static JarURLConnection getJarURLConnection(Class c) throws IOException, ClassCastException {
    String resourceName = "/" + c.getName().replace('.', '/') + ".class";
    URL url = c.getResource(resourceName);
    return (JarURLConnection) url.openConnection();
}