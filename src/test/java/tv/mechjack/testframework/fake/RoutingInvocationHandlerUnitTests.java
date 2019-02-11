package tv.mechjack.testframework.fake;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;

import tv.mechjack.testframework.TestClock;

public class RoutingInvocationHandlerUnitTests {

  @Test
  public final void invoke_withHandler_resultIsHandlerExecuted()
      throws Throwable {
    final Method method = TestClock.class.getMethod("currentTime");
    final InvocationCounter handler = new InvocationCounter();
    final RoutingInvocationHandler subjectUnderTest = new RoutingInvocationHandler();
    subjectUnderTest.addHandler(method, handler);

    subjectUnderTest.invoke(null, method, new Object[] {});

    assertThat(handler.getCallCount()).isOne();
  }

  @Test
  public final void invoke_withoutHandler_resultIsHandlerExecuted()
      throws Throwable {
    final Method method = TestClock.class.getMethod("currentTime");
    final RoutingInvocationHandler subjectUnderTest = new RoutingInvocationHandler();

    final Object result = subjectUnderTest.invoke(null, method, new Object[] {});

    assertThat(result).isNull();
  }

}
