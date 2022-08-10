public class Level extends AbstractLevel {

    public Level(String input) {
        size = input.split("\n").length;
        components = new LevelComponent[size][size];
        ElementFactory factory = ElementFactory.getInstance();

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(input.charAt(i) != '\n'){
                    components[i][j] = factory.getElement(input.charAt(count));
                }
                count++;
            }
            count++;
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LevelComponent[] ListComp:components) {
            for (LevelComponent comp: ListComp) {
                builder.append(comp.draw());
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    LevelComponent[][] getComponents() {
        return components;
    }

    @Override
    int getSize() {
        return size*size;
    }

    /* Example of level building with this String : String s = "#-K\n-D-\n#-K\n"
     * Gives : LevelComponent[][] componentsObjects = {
     *                                        {new Wall(), new Floor(), new Key()},
     *                                        {new Floor(), new Door(), new Floor()},
     *                                        {new Wall(), new Floor(), new Key()}}
     */


    // YOUR CODE HERE
}
