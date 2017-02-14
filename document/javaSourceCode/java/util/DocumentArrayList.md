### add 方法
有两个实现分别为 `add(E e)` 与 `add(index, e)`

1. `add(e)` 直接在最后添加元素；
2. `add(index, e)` 在index 上添加元素，1.6 的实现过程：
	1. 判断index 是否越界；
	2. 容量加一，这里的加一是保证最小加一，实际可能加的较多，1.5倍
	3. 使用`System.arraycopy()` 把index 及以后的元素拷贝到index+1处；
	4. 最后把e 放在index 的位置

### remove 方法
看1.6中有两个实现`remove(int index)`和`remove(Object o)`，看代码中index 直接作为索引使用了，有一个问题：如果list 中保存的是int 型会是什么样的结果？
```java
List<Integer> list = new ArrayList<Integer>();
list.add(100);
//		list.remove(100);
list.remove(new Integer(100));
```
经过测试：

1. `list.remove(100);` 会报错，就是说jvm 认为100 是index, 而不是存储的元素；
2. `list.remove(new Integer(100))` 不使用基本类型，则可以正确删除，说明jvm 把`new Integer(100)` 作为元素处理


