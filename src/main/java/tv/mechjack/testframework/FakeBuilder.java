package tv.mechjack.testframework;

import java.lang.reflect.Method;

public interface FakeBuilder<T> {

  MethodInvocationBuilder<T> forMethod(String methodName, Class<?>... parameterTypes);

  MethodInvocationBuilder<T> forMethod(Method method);

  T build();

}
