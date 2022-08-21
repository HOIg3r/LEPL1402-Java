import org.junit.Test;

import static org.junit.Assert.*;

public class SectionTest {

    private class O implements SectionObserver {
        private int cars = -1;
        private boolean isFlashed = false;
        private String flashedPlate;
        private float flashedSpeed;
        
        public void flashSpeeding(String numberPlate,
                                  float kilometersPerHour) {
            isFlashed = true;
            flashedPlate = numberPlate;
            flashedSpeed = kilometersPerHour;
        }

        public void numberOfCarsChanged(int numberOfCars) {
            cars = numberOfCars;
        }

        public int getNumberOfCars() {
            return cars;
        }

        public boolean isFlashed() {
            return isFlashed;
        }

        public String getFlashedPlate() {
            return flashedPlate;
        }

        public float getFlashedSpeed() {
            return flashedSpeed;
        }
    }

    @Test
    public void test1() {
        O o = new O();
        
        Section section = new Section(120, 10);  // Maximum speed = 120km, on a 10km section
        section.register(o);

        assertEquals(-1, o.getNumberOfCars());
        section.carEntered("ABC", 15);
        assertEquals(1, o.getNumberOfCars());
        section.carExited("ABC", 17);  // 120 minutes for 10km = 5km/h
        assertEquals(0, o.getNumberOfCars());
        assertFalse(o.isFlashed());
    }

    
    @Test
    public void test2() {
        O o = new O();
        
        Section section = new Section(60, 60);  // Maximum speed = 60km, on a 60km section
        section.register(o);

        assertEquals(-1, o.getNumberOfCars());
        section.carEntered("ABC", 16);
        assertEquals(1, o.getNumberOfCars());
        section.carExited("ABC", 16.0f + 59.0f / 60.0f);
        assertEquals(0, o.getNumberOfCars());
        
        assertTrue(o.isFlashed());
        assertEquals(60.0f / 59.0f * 60.0f, o.getFlashedSpeed(), 0.1f);  // 59 minutes for 60km
        assertEquals("ABC", o.getFlashedPlate());
    }

    
    @Test
    public void test3() {
        O o = new O();
        
        Section section = new Section(60, 60);  // Maximum speed = 60km, on a 60km section
        section.register(o);

        assertEquals(-1, o.getNumberOfCars());
        section.carEntered("ABC", 16);
        assertEquals(1, o.getNumberOfCars());
        section.carExited("ABC", 16.0f + 61.0f / 60.0f);  // No speeding (61 minutes for 60km)
        assertEquals(0, o.getNumberOfCars());
        assertFalse(o.isFlashed());
    }


    @Test
    public void test4() {
        O o = new O();
        
        Section section = new Section(60, 60);
        section.register(o);

        assertEquals(-1, o.getNumberOfCars());
        section.carEntered("ABC", 16);
        assertEquals(1, o.getNumberOfCars());
        section.carEntered("DEF", 17);
        assertEquals(2, o.getNumberOfCars());
        section.carEntered("XYZ", 18);
        assertEquals(3, o.getNumberOfCars());
        section.carExited("ABC", 19);
        assertEquals(2, o.getNumberOfCars());
        section.carExited("XYZ", 20);
        assertEquals(1, o.getNumberOfCars());
        section.carExited("DEF", 21);
        assertEquals(0, o.getNumberOfCars());
    }


    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        Section section = new Section(60, 60);
        section.carEntered("ABC", 16);
        section.carEntered("ABC", 17);  // Twice the same car
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        Section section = new Section(60, 60);
        section.carEntered("ABC", 16);
        section.carExited("ABC", 15);  // Negative speed
    }
    
    
}
