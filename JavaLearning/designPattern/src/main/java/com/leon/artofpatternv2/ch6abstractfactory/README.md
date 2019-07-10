抽象工厂模式总结
=
主要优点

1. 隔离了具体类的生成，使得客户端不需要知道什么被创建
2. 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。
3. 增加新的产品族很方便，无须修改已有系统

主要缺点
1. 增加新的产品等级结构麻烦，需要对原有系统进行较大的修改

本例中，产品族是不同颜色，产品等级结构是 button/  textfield