private Rectangle2D.Double getRectangle() {
    if (unionPosition == null || unionPosition == UnionPosition.NONE) {
        return null;
    }
    Rectangle2D.Double union = new Rectangle2D.Double();
    if (unionPosition.alignment == Alignment.VERTICAL) {
        if (background.alignment == Alignment.VERTICAL && stripes < 3) {
            union.width = (double) WIDTH / stripes;
            if (stripes == 2 && unionPosition == UnionPosition.RIGHT) {
                union.x = WIDTH / 2;
            }
        } else {
            union.width = WIDTH / 3;
            union.x = unionPosition.index * union.width;
        }
        union.height = HEIGHT;
    } else if (unionPosition.alignment == Alignment.HORIZONTAL) {
        if (background.alignment == Alignment.HORIZONTAL && stripes < 3) {
            union.height = (double) HEIGHT / stripes;
            if (stripes == 2 && unionPosition == UnionPosition.BOTTOM) {
                union.y = HEIGHT / 2;
            }
        } else {
            union.height = HEIGHT / 3;
            union.y = unionPosition.index * union.height;
        }
        union.width = WIDTH;
    } else {
        union.width = WIDTH / 2;
        union.height = HEIGHT / 2;
        if (background.alignment == Alignment.HORIZONTAL) {
            union.height = (stripes < 3) ? HEIGHT / 2 : (stripes / 2.0) * getStripeHeight(background.alignment);
        } else if (background.alignment == Alignment.VERTICAL) {
            union.width = (stripes < 3) ? WIDTH / 2 : (stripes / 2.0) * getStripeWidth(background.alignment);
        }
        if (decoration == Decoration.GREEK_CROSS || decoration == Decoration.CROSS) {
            union.width = (WIDTH - DECORATION_SIZE) / 2;
            union.height = (HEIGHT - DECORATION_SIZE) / 2;
        } else if (decoration == Decoration.SCANDINAVIAN_CROSS) {
            union.width = (WIDTH - DECORATION_SIZE) / 2 - CROSS_OFFSET;
            union.height = (HEIGHT - DECORATION_SIZE) / 2;
        }
    }
    return union;
}