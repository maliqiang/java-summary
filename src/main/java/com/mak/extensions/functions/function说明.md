1. 单个参数的时候可以实现Function接口
2. 多个参数的时候可以使用BiFunction接口
3. 如果一个Function的输入参数类型和输入参数类型相同，即Function<T, T>，这时可以使用 UnaryOperator<T>