public static void main(String[] args) throws Exception {
    String riverName = "data/rules/classic/resources/images/terrain/" + "ocean/center0.png";
    String riverDir = "data/rules/classic/resources/images/river";
    BufferedImage river = ImageIO.read(new File(riverName));
    river = river.getSubimage(44, 22, 40, 20);
    Rectangle2D rectangle = new Rectangle(0, 0, river.getWidth(), river.getHeight());
    TexturePaint texture = new TexturePaint(river, rectangle);
    Stroke minor = new BasicStroke(4);
    Stroke major = new BasicStroke(6);
    int[] branches = { 1, 0, 0, 0 };
    for (int index = 1; index < 81; index++) {
        BufferedImage result = new BufferedImage(128, 64, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.setPaint(texture);
        String name = getName(branches);
        int count = branchCount(branches);
        for (int branch = 0; branch < branches.length; branch++) {
            int size = branches[branch];
            if (size > 0) {
                g.setStroke(size == 1 ? minor : major);
                int next = (branch + 1) % 4;
                int other = (branch + 2) % 4;
                Path2D.Float bend = new Path2D.Float();
                float px = (POINTS[branch].x + POINTS[other].x) / 2;
                float py = (POINTS[branch].y + POINTS[other].y) / 2;
                bend.moveTo(POINTS[branch].x, POINTS[branch].y);
                if (count == 1) {
                    bend.lineTo(px, py);
                    g.draw(bend);
                    break;
                } else if (branches[other] > 0) {
                    bend.lineTo(px, py);
                    bend.moveTo(POINTS[branch].x, POINTS[branch].y);
                }
                if (branches[next] > 0) {
                    bend.quadTo(CENTER.x, CENTER.y, (POINTS[next].x + CENTER.x) / 2, (POINTS[next].y + CENTER.y) / 2);
                    bend.lineTo(POINTS[next].x, POINTS[next].y);
                }
                g.draw(bend);
            }
        }
        g.dispose();
        ImageIO.write(result, "png", new File(riverDir, "river" + name + ".png"));
        branches = nextBranch(branches);
    }
}