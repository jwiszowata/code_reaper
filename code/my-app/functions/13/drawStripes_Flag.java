private void drawStripes(Graphics2D g, Alignment alignment, int stripes) {
    int colors = backgroundColors.size();
    double stripeWidth = getStripeWidth(alignment);
    double stripeHeight = getStripeHeight(alignment);
    double x = (alignment == Alignment.VERTICAL) ? stripeWidth : 0;
    double y = (alignment == Alignment.HORIZONTAL) ? stripeHeight : 0;
    Rectangle2D.Double rectangle = new Rectangle2D.Double();
    for (int index = 0; index < stripes; index++) {
        g.setColor(backgroundColors.get(index % colors));
        rectangle.setRect(index * x, index * y, stripeWidth, stripeHeight);
        g.fill(rectangle);
    }
}