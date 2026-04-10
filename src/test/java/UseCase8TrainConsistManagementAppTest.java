import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

public class UseCase8TrainConsistManagementTestApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("General", 90));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, filteredBogies.size());
        assertTrue(filteredBogies.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(0, filteredBogies.size());
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(0, filteredBogies.size());
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("Premium", 85));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(3, filteredBogies.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(0, filteredBogies.size());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, filteredBogies.size());
        assertEquals(bogies.size(), filteredBogies.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(0, filteredBogies.size());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        int originalSize = bogies.size();

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, bogies.size());
        assertEquals(3, bogies.size());
        assertEquals(1, filteredBogies.size());
    }
}