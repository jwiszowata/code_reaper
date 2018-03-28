public static void main(String[] args) throws Exception {
    if ("--palette".equals(args[0])) {
        RandomAccessFile writer = new RandomAccessFile(args[1], "rw");
        byte width = 58;
        byte height = 72;
        int size = width * height * 3 + header.length;
        layer1 = new byte[size];
        for (int i = 0; i < header.length; i++) {
            layer1[i] = header[i];
        }
        Arrays.fill(layer1, header.length, header.length + width * height, (byte) 25);
        int ROWS = 32;
        int COLUMNS = 8;
        int offset = header.length + width + 1;
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                byte value = (byte) (COLUMNS * y + x);
                if ((value & 24) == 24 && x > 2) {
                    value = 26;
                }
                layer1[offset + x] = value;
            }
            offset += width;
        }
        writer.write(layer1);
    } else {
        RandomAccessFile reader = new RandomAccessFile(args[0], "r");
        reader.read(header);
        System.out.println(String.format("Map width:  %02d", (int) header[WIDTH]));
        System.out.println(String.format("Map height: %02d", (int) header[HEIGHT]));
        int size = header[WIDTH] * header[HEIGHT];
        layer1 = new byte[size];
        reader.read(layer1);
        int index = 0;
        for (int y = 0; y < header[HEIGHT]; y++) {
            for (int x = 0; x < header[WIDTH]; x++) {
                int decimal = layer1[index] & 0xff;
                char terrain = tiletypes[decimal & 31];
                int overlay = decimal >> 5;
                switch(overlay) {
                    case // hill
                    1:
                        terrain = '^';
                        break;
                    case // minor river
                    2:
                        terrain = '~';
                        break;
                    case // hill + minor river
                    3:
                        terrain = 'x';
                        break;
                    case // mountain
                    5:
                        terrain = '*';
                        break;
                    case // major river
                    6:
                        terrain = '=';
                        break;
                    case // mountain + major river
                    7:
                        terrain = 'X';
                        break;
                    default:
                        break;
                }
                ;
                System.out.print(terrain);
                index++;
            }
            System.out.println('\n');
        }
        System.out.println('\n');
    }
}