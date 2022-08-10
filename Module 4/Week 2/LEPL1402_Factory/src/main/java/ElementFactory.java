public class ElementFactory extends Factory {

    private static final ElementFactory ELEMENT_FACTORY_SINGLETON = new ElementFactory();

    public static ElementFactory getInstance() {
        return ELEMENT_FACTORY_SINGLETON;
    }

    @Override
    LevelComponent getElement(char c) {
        switch (c){
            case 'K':
                return new Key();
            case 'D':
                return new Door();
            case '#':
                return new Wall();
            case '-':
                return new Floor();
            default:
                throw new IllegalArgumentException();
        }
    }
}