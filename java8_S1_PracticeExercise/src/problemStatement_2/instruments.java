package problemStatement_2;

interface Instrument {
    void play();
}

class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("Piano is playing tan tan tan tan");
    }
}

class Flute implements Instrument {
    @Override
    public void play() {
        System.out.println("Flute is playing toot toot toot toot");
    }
}

class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("Guitar is playing tin tin tin");
    }
}

public class instruments {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[10];

        instruments[0] = new Piano();
        instruments[1] = new Flute();
        instruments[2] = new Guitar();

        for (int i = 3; i < 10; i++) {
            if (i % 3 == 0) {
                instruments[i] = new Piano();
            } else if (i % 3 == 1) {
                instruments[i] = new Flute();
            } else {
                instruments[i] = new Guitar();
            }
        }

        for (int i = 0; i < instruments.length; i++) {
            instruments[i].play();
            // Check which object is stored at which index
            if (instruments[i] instanceof Piano) {
                System.out.println("Object at index " + i + ": Piano");
            } else if (instruments[i] instanceof Flute) {
                System.out.println("Object at index " + i + ": Flute");
            } else if (instruments[i] instanceof Guitar) {
                System.out.println("Object at index " + i + ": Guitar");
            }
        }
    }
}

