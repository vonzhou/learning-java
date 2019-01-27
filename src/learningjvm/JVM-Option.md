# JVM选项

-Xms 设置最小堆大小

-Xmx 设置最大堆大小

-Xmn  新生代大小

-XX:SurvivorRatio 新生代中Survivor占的比率,注意理解.可以结合Hotspot的代码:

```cpp
﻿// 堆大小？
  uintx size = _virtual_space.reserved_size();
  // Survivor大小
  _max_survivor_size = compute_survivor_size(size, alignment);
  // Eden大小
  _max_eden_size = size - (2*_max_survivor_size);
```

```cpp
﻿// 计算Survivor空间的大小，从这里可以更好的理解 -XX:SurvivorRatio=8 的含义
  // Return the size of a survivor space if this generation were of size gen_size.
  size_t compute_survivor_size(size_t gen_size, size_t alignment) const {
    size_t n = gen_size / (SurvivorRatio + 2);
    return n > alignment ? align_size_down(n, alignment) : alignment;
  }
```