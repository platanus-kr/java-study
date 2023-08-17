# reference practice

### 목적

> 간접 참조와 직접 참조의 차이와 어디까지가 적절한지 확인해보는 모듈

### Direct Reference (by reference)

> `com.jpapractice01.byreference`

- Order의 Item까지는 적절했으니 Delivery까지 가지고 가는 부분은 좀 이상한듯..   
-> 왜냐햐면 Delivery는 Order의 일부분이긴 하나 모든 주문이 Delivery를 갖고있지 않기 때문임.


### Reference by identify (by identifier)

> `com.jpapractice01.byidentifier`

- Delivery를 분리해줌으로써 자유로워졌으나 Order에서 Delivery를 확인하기 위해서 쿼리가 두번 나가야함
