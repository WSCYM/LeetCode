## kz

### 介绍一下

我负责的模块是配网改造模块和开工竣工模块。

1. 配网改造模块：申请用电的企业首先需要在小程序上填写一些信息，比如企业信息，用电类型，多少千瓦，需要什么器材以及数量之类的，填写完成后送往运检部审核。审核如果不通过告知用户不通过的原因，通过之后根据填写的内容生成一个word形式的答复单，还会根据用户挑选的物料生产一个预算图。然后将答复单转换成png格式之后将答复单和预算图返回给客户，客户同意后签字，获得电子签名。然后就可以帮客户接电了。
2. 开工竣工模块：施工单位获得开工许可后填写开工报告单（开工时间，工程内容，施工单位），生成开工报告单后发给各部门，各部门确认无误后根据需采购的器械，施工地点，工作内容等确定施工时间，施工完成后更新施工状态，请客户验收。客户验收结束后将相关信息归档。

## 物资

### 介绍一下

我负责的模块是物资维护模块和库房维护模块。

1. 物资维护模块就是维护物资的一些基本信息，比如物资类别，物资所在库房。物资计量单位，物资数量等。

2. 库房维护就是维护库房的一些基本信息，比如库房负责人，库房所在地等等。
3. 物资入库，物资出库。内部调拨。

亮点：多线程从Excel读取数据写入到数据库中。

借用了生产者消费者设计模式的思想,专门开一个读线程，（读取快，主要是写操作耗时，一个够用），这个线程使用POI读取EXCEL文件中的记录，该线程每次读取到记录都将其存入阻塞队列。其次，再设置若4个线程，这些线程负责从上述队列中取出记录（对象）后对记录中的数据进行校验，写入数据库。Reader线程读取完所以记录之后，要“通知”Processor线程（将一个flag）设置为false。

经常被问：**优化之前跑一次多少秒，优化之后跑一次多少秒？**

