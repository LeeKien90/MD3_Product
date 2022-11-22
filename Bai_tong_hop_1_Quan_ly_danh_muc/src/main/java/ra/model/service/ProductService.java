package ra.model.service;

import java.util.List;

public interface ProductService<T,V> extends ProductManagermentService<T,V> {
    List<T> seachProductByName(String name);
}
