package ra.model.dao;

import java.util.List;

public interface IProductDao<T,V> extends IProductManagermentDao<T,V>{
    List<T> seachProductByName(String name);
}
