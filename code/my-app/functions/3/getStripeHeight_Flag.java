private double getStripeHeight(Alignment alignment) {
    return (alignment == Alignment.VERTICAL) ? HEIGHT : (double) HEIGHT / stripes;
}