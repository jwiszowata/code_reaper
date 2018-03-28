private double getStripeWidth(Alignment alignment) {
    return (alignment == Alignment.HORIZONTAL) ? WIDTH : (double) WIDTH / stripes;
}