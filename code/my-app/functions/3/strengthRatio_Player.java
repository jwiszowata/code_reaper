public static double strengthRatio(double ours, double theirs) {
    return (ours == 0.0) ? 0.0 : ours / (ours + theirs);
}