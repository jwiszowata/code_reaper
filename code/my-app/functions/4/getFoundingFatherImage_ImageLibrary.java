public static BufferedImage getFoundingFatherImage(FoundingFather father, boolean grey) {
    String resource = "image.flavor." + father.getId();
    return grey ? ResourceManager.getGrayscaleImage(resource, 1f) : ResourceManager.getImage(resource);
}