private static List<AnimationEvent> loadEvents(ZipInputStream zipStream) throws IOException {
    List<AnimationEvent> events = new ArrayList<>();
    final Map<String, BufferedImage> loadingImages = new HashMap<>();
    final List<String> loadingDescriptor = new ArrayList<>();
    try {
        BufferedReader in;
        ZipEntry ze;
        while ((ze = zipStream.getNextEntry()) != null) {
            if (ANIMATION_DESCRIPTOR_FILE.equals(ze.getName())) {
                in = new BufferedReader(new InputStreamReader(zipStream, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    loadingDescriptor.add(line);
                }
            } else {
                loadingImages.put(ze.getName(), ImageIO.read(zipStream));
            }
            zipStream.closeEntry();
        }
    } finally {
        try {
            zipStream.close();
        } catch (IOException e) {
        }
    }
    if (loadingDescriptor.isEmpty()) {
        throw new IOException(ANIMATION_DESCRIPTOR_FILE + " is missing from the SZA.");
    }
    for (String line : loadingDescriptor) {
        final int idx = line.indexOf('(');
        final int idx2 = line.indexOf("ms)");
        if (idx < 0 || idx2 <= idx) {
            throw new IOException(ANIMATION_DESCRIPTOR_FILE + " should use the format: FILNAME (TIMEms)");
        }
        final String imageName = line.substring(0, idx).trim();
        final int ms = Integer.parseInt(line.substring(idx + 1, idx2));
        final BufferedImage image = loadingImages.get(imageName);
        if (image == null) {
            throw new IOException("Could not find referenced image: " + imageName);
        }
        events.add(new ImageAnimationEventImpl(image, ms));
    }
    return events;
}