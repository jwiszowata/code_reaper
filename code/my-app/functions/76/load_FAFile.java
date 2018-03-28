private void load(InputStream is) throws IOException {
    letters.clear();
    BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    String line = in.readLine();
    if (line == null || !line.startsWith("FontAnimationFile")) {
        throw new IllegalStateException("Not a FAF");
    }
    line = in.readLine();
    if (line == null) {
        throw new IllegalStateException("Max height expected");
    }
    StringTokenizer st = new StringTokenizer(line);
    maxHeight = Integer.parseInt(st.nextToken());
    line = in.readLine();
    while (line != null && !line.startsWith("[Chars]")) {
        String name = line;
        if ((line = in.readLine()) == null)
            break;
        st = new StringTokenizer(line);
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int numberOfPoints = Integer.parseInt(st.nextToken());
        int[] xs = new int[numberOfPoints];
        int[] ys = new int[numberOfPoints];
        if ((line = in.readLine()) == null)
            break;
        st = new StringTokenizer(line);
        for (int i = 0; i < numberOfPoints; i++) {
            xs[i] = Integer.parseInt(st.nextToken());
        }
        if ((line = in.readLine()) == null)
            break;
        st = new StringTokenizer(line);
        for (int i = 0; i < numberOfPoints; i++) {
            ys[i] = Integer.parseInt(st.nextToken());
        }
        FAName newLetter = new FAName();
        newLetter.width = width;
        newLetter.height = height;
        newLetter.points = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            newLetter.points[i] = new Point(xs[i], ys[i]);
        }
        letters.put(name, newLetter);
        line = in.readLine();
    }
    line = in.readLine();
    while (line != null) {
        st = new StringTokenizer(line.substring(1));
        char letter = line.charAt(0);
        int advance = Integer.parseInt(st.nextToken());
        int numberOfPoints = Integer.parseInt(st.nextToken());
        int[] xs = new int[numberOfPoints];
        int[] ys = new int[numberOfPoints];
        if ((line = in.readLine()) == null)
            break;
        st = new StringTokenizer(line);
        for (int i = 0; i < numberOfPoints; i++) {
            xs[i] = Integer.parseInt(st.nextToken());
        }
        if ((line = in.readLine()) == null)
            break;
        st = new StringTokenizer(line);
        for (int i = 0; i < numberOfPoints; i++) {
            ys[i] = Integer.parseInt(st.nextToken());
        }
        FALetter newLetter = new FALetter();
        newLetter.advance = advance;
        newLetter.points = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            newLetter.points[i] = new Point(xs[i], ys[i]);
        }
        letters.put(letter, newLetter);
        line = in.readLine();
    }
}