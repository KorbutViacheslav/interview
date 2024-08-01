enum Level {
    LOW {
        @Override
        int getLevelValue() {
            return 1;
        }
    }, MEDIUM {
        @Override
        int getLevelValue() {
            return 2;
        }
    }, HIGH {
        @Override
        int getLevelValue() {
            return 3;
        }
    };

    abstract int getLevelValue();
}

class AbstractExample {
    public static void main(String[] args) {
        System.out.println(Level.LOW.getLevelValue()); // Виведе ?
        System.out.println(Level.MEDIUM.getLevelValue()); // Виведе ?
        System.out.println(Level.HIGH.getLevelValue()); // Виведе ?
    }
}
