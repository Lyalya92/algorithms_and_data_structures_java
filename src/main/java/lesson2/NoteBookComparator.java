package lesson2;

import java.util.Comparator;

public class NoteBookComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Notebook n1 = (Notebook) o1;
        Notebook n2 = (Notebook) o2;
        if (Double.compare(n2.getPrice(), n1.getPrice()) != 0) {
            return Double.compare(n2.getPrice(), n1.getPrice());
        } else {
            if (Integer.compare(n2.getRam(), n1.getRam()) !=0 ) {
                return Integer.compare(n2.getRam(), n1.getRam());
            } else {
                return Integer.compare(n2.getBrand().getValue(), n1.getBrand().getValue());
            }
        }
    }
}
