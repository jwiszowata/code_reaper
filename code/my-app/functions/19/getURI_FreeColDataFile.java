protected URI getURI(String name) {
    try {
        if (name.startsWith("urn:")) {
            try {
                return new URI(name);
            } catch (URISyntaxException e) {
                logger.log(Level.WARNING, "Resource creation failure with: " + name, e);
                return null;
            }
        } else if (file.isDirectory()) {
            return new File(file, name).toURI();
        } else {
            return new URI("jar:file", file + "!/" + jarDirectory + name, null);
        }
    } catch (URISyntaxException e) {
        logger.log(Level.WARNING, "Failed to lookup: " + file + "/" + name, e);
        return null;
    }
}