# concurrent
&lt;&lt;java并发之美>>读书笔记

用于面试和深入底层做准备

<br>
要求:<br>
①过一遍源码,能画出核心Api的调用流程图</br>
②总结各种工具不同的实现方式差异,方便记忆和面试....</br>
ps:最近看知乎的面经我有点害怕,阿里社招的面经看多了我感觉自己啥都不会...面试简直无底洞</br></br>

锁的原始工具:
  1. Synchronized
  2. volatile

同步器的原值工具
  1. Object的wait()+notify()+notifyAll()


JUC的基本工具
  1. 线程阻塞工具.  LockSupport
  2. 值的原子操作工具:  Unsafe
  3. 保存阻塞线程的工具: AQS


线程隔离的变量:
  1. ThreadLocalRandom
  
可重入锁:
  1. ReentrantLock
  2. ReentrantReadWriteLock
  
并发队列
  1. ConcurrentLinkedQueue:  自旋锁实现
  2. LinkedBlockingQueue: 链表实现
  3. ArrayBlockingQueue:  数组实现
  4. PriorityBlockingQueue : 优先队列
  4. DelayQueue: 不知道用途???
  
线程池
 1. threadPoolExecutor
 
线程同步器:
 1. CounDownLatch: 单次
 2. CycliBarrier: 多次
 3. Semaphore: 模拟pv操作
 
并发线性表:
 1. copyOnWriteArrayList: 写时复制来保证弱一致性
 
并发Map:
 1. ConcurrentMap:  锁细化+红黑树
 
 



