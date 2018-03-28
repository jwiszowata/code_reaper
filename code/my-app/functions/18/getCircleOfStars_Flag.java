private GeneralPath getCircleOfStars(double radius) {
    double phi = Math.PI * 2 / stars;
    GeneralPath unionPath = new GeneralPath();
    if (stars == 0) {
    } else if (stars == 1) {
        unionPath = getStar(2, 0, 0);
    } else if (stars == 2) {
        unionPath.append(getStar(1.5, -radius, 0), false);
        unionPath.append(getStar(1.5, radius, 0), false);
    } else {
        for (int i = 0; i < stars; i++) {
            double x = -radius - radius * Math.sin(i * phi);
            double y = -radius * Math.cos(i * phi);
            unionPath.append(getStar(x, y), false);
        }
    }
    return unionPath;
}