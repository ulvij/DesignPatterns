package singleton

// singleton is created by simply declaring an object
// contrary to a class, an object can't have any constructor, will be executed lazily (upon first access - without having to rely on a locking algorithm like the double-check locking) and also is a thread-safe
// we can use init block for some intializations code is indeed
// object actually relies on Java static initialization block
// this code will be compiled to the following equivalent Java code :
// public final class SomeSingleton {
//   public static final SomeSingleton INSTANCE;
//
//   private SomeSingleton() {
//      INSTANCE = (SomeSingleton)this;
//      System.out.println("init complete");
//   }
//
//   static {
//      new SomeSingleton();
//   }
// }

// Disadvantages of Kotlin object keywork : if the initialization code requires some extra argument? Because a Kotlin object can’t have any constructor, you can’t pass any argument to it.
object SingletonWithoutParam {
    fun getInstance():SingletonWithoutParam{
        return this
    }
}