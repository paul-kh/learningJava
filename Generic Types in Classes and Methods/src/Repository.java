import java.util.Objects;
// T is a type placeholder which will be placed by various types
// when instantiating the class Repository
public class Repository<T> {

    public T value;

    public T getValue() {
        return value;
    }

}
