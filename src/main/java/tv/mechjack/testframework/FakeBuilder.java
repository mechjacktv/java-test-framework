package tv.mechjack.testframework;

import java.lang.reflect.Method;

public interface FakeBuilder<T> {

  MethodHandlerBuilder<T> forMethod(String methodName, Class<?>... parameterTypes);

  MethodHandlerBuilder<T> forMethod(Method method);

  T build();

}
