/**
 * Uses `java.lang.reflect.Proxy` to create interface implementation fakes which
 * can be used for testing.
 *
 * ## Example Use
 *
 * ```java
 * public final class MyServiceUnitTests {
 *
 *  {@literal @}Rule
 *   public final TestFramework testFramework = new TestFramework();
 *
 *  {@literal @}Test
 *   public final void testUsingSimpleFake() {
 *     final FakeFactory fakeFactory =
 *         testFramework.getInstance(FakeFactory.class);
 *     final MyInterface myFake = fakeFactory.fake(MyInterface.class);
 *     // the rest of the test implementation
 *   }
 *
 *  {@literal @}Test
 *   public final void testUsingFakeBuilder() {
 *     final FakeFactory fakeFactory =
 *         testFramework.getInstance(FakeFactory.class);
 *     final FakeBuilder<MyInterface> fakeBuilder =
 *         fakeFactory.fakeBuilder(MyInterface.class);
 *     fakeBuilder.forMethod("getValue", new Class[]{ String.class })
 *         .setHandler(new MyMethodInvocationHandler());
 *     final MyInterface myFake = fakeBuilder.build();
 *     // the rest of the test implementation
 *   }
 *
 * }
 * ```
 *
 * ## Convenience Methods on `TestFramework`
 *
 * This pattern is common enough that there are convenience on
 * `TestFramework` that wrap the `FakeFactory` instance.
 *
 * ```java
 * public final class MyServiceUnitTests {
 *
 *  {@literal @}Rule
 *   public final TestFramework testFramework = new TestFramework();
 *
 *  {@literal @}Test
 *   public final void testUsingSimpleFake() {
 *     final MyInterface myFake = this.testFramework.fake(MyInterface.class);
 *     // the rest of the test implementation
 *   }
 *
 *  {@literal @}Test
 *   public final void testUsingFakeBuilder() {
 *     final FakeBuilder<MyInterface> fakeBuilder =
 *         this.testFramework.fakeBuilder(MyInterface.class);
 *     fakeBuilder.forMethod("getValue", new Class[]{ String.class })
 *         .setHandler(new MyMethodInvocationHandler());
 *     final MyInterface myFake = fakeBuilder.build();
 *     // the rest of the test implementation
 *   }
 *
 * }
 * ```
 */
package tv.mechjack.testframework.fake;
