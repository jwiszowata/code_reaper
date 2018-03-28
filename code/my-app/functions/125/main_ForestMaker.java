public static void main(String[] args) throws IOException {
    if (args.length == 0) {
        System.out.println("Usage: ForestMaker <directory>...");
        System.out.println("Directory name should match a directory in");
        System.out.println("   " + DESTDIR);
        System.exit(1);
    }
    String riverName = "data/rules/classic/resources/images/terrain/" + "ocean/center0.png";
    BufferedImage river = ImageIO.read(new File(riverName));
    river = river.getSubimage(44, 22, 40, 20);
    Rectangle2D rectangle = new Rectangle(0, 0, river.getWidth(), river.getHeight());
    TexturePaint texture = new TexturePaint(river, rectangle);
    for (String arg : args) {
        File sourceDirectory = new File(arg);
        if (!sourceDirectory.exists()) {
            System.out.println("Source directory " + arg + " does not exist.");
            continue;
        }
        String baseName = sourceDirectory.getName();
        File destinationDirectory = new File(DESTDIR, baseName);
        if (!destinationDirectory.exists()) {
            System.out.println("Destination directory " + destinationDirectory.getPath() + " does not exist.");
            continue;
        }
        File[] imageFiles = sourceDirectory.listFiles();
        if (imageFiles == null) {
            System.out.println("No images found in source directory " + arg + ".");
            continue;
        } else {
            System.out.println(imageFiles.length + " images found in source directory " + arg + ".");
        }
        List<BufferedImage> images = new ArrayList<>(imageFiles.length);
        int maximumHeight = 0;
        for (File imageFile : imageFiles) {
            if (imageFile.isFile() && imageFile.canRead()) {
                try {
                    BufferedImage image = ImageIO.read(imageFile);
                    images.add(image);
                    if (image.getHeight() > maximumHeight) {
                        maximumHeight = image.getHeight();
                    }
                } catch (IOException e) {
                    System.out.println("Unable to load image " + imageFile.getName() + ":\n");
                    e.printStackTrace();
                }
            }
        }
        int numberOfImages = images.size();
        Random random = new Random(1492);
        for (int index = 0; index < 16; index++) {
            BufferedImage base = new BufferedImage(BASE_WIDTH, BASE_HEIGHT + MARGIN, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = base.createGraphics();
            g.translate(HALF_WIDTH, BASE_HEIGHT + MARGIN);
            g.setPaint(texture);
            String counter = "";
            boolean[] branches = new boolean[4];
            if (index > 0) {
                for (int i = 0; i < POWERS_OF_TWO.length; i++) {
                    if ((index & POWERS_OF_TWO[i]) == POWERS_OF_TWO[i]) {
                        branches[i] = true;
                        counter += "1";
                    } else {
                        counter += "0";
                    }
                }
            }
            Point right = new Point(HALF_WIDTH, -HALF_HEIGHT);
            Point left = new Point(-HALF_WIDTH, -HALF_HEIGHT);
            int treeCount = 0;
            if (branches[0] || branches[2]) {
                left.translate(RIVER_WIDTH, RIVER_HEIGHT);
                treeCount++;
            }
            if (branches[1] || branches[3]) {
                right.translate(-RIVER_WIDTH, RIVER_HEIGHT);
                treeCount++;
            }
            if (drawBorders) {
                int dx = right.x + left.x;
                int dy = right.y + left.y;
                g.setColor(Color.RED);
                g.drawLine(0, 0, right.x, right.y);
                g.drawLine(right.x, right.y, dx, dy);
                g.drawLine(dx, dy, left.x, left.y);
                g.drawLine(left.x, left.y, 0, 0);
            }
            if (drawTrees) {
                List<ImageLocation> trees = new ArrayList<>(TREES);
                int numberOfTrees = (6 - treeCount) * TREES / 6;
                int count = 0;
                while (count < numberOfTrees) {
                    BufferedImage image = images.get(random.nextInt(numberOfImages));
                    int width = image.getWidth();
                    int height = image.getHeight();
                    int halfWidth = width / 2;
                    float a = random.nextFloat();
                    float b = random.nextFloat();
                    int x = (int) (a * right.x + b * left.x);
                    int y = (int) (a * right.y + b * left.y);
                    if (x - halfWidth < -HALF_WIDTH) {
                        x = -HALF_WIDTH + halfWidth;
                    }
                    if (x + halfWidth > HALF_WIDTH) {
                        x = HALF_WIDTH - halfWidth;
                    }
                    int crown = Math.max(y - height, -(BASE_HEIGHT + MARGIN));
                    if ((branches[1] || branches[3]) && crown < -BASE_HEIGHT + RIVER_HEIGHT + (x + halfWidth) / 2) {
                        continue;
                    }
                    if ((branches[0] || branches[2]) && crown < -BASE_HEIGHT + RIVER_HEIGHT - (x - halfWidth) / 2) {
                        continue;
                    }
                    trees.add(new ImageLocation(image, x - halfWidth, crown));
                    count++;
                }
                trees.sort(Comparator.naturalOrder());
                for (ImageLocation imageLocation : trees) {
                    g.drawImage(imageLocation.image, imageLocation.x, imageLocation.y, null);
                }
            }
            g.dispose();
            ImageIO.write(base, "png", new File(destinationDirectory, sourceDirectory.getName() + counter + ".png"));
        }
    }
}