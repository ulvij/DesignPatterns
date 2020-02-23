# Singleton Design Pattern

Ensure a class has only one instance, and provide a global point of access to it.

### Check list
- Define a private "static" attribute in the "single instance" class
- Define a public "static" accessor function in the class
- Do "lazy initialization" (creation on first use) in the accessor function
- Define all constructors to be __protected__ or __private__
- Should be thread-safe

Singleton is created by simply declaring an ``object`` keyword :

```kotlin
object SingletonWithoutParam {
    init {
        // you can to some initializations here
    }
}
```

Contrary to a class, an ``object`` 
- can't have any constructor
- will be executed lazily (upon first access - without having to rely on a locking algorithm like the __double-check locking__) 
- also is a thread-safe

We can use init block for some initialization code is indeed

``object`` actually relies on Java static initialization block. So, this code will be compiled to the following equivalent Java code :

```java
public final class SomeSingleton {
   private static final SomeSingleton INSTANCE;

   private SomeSingleton() {
      INSTANCE = (SomeSingleton)this;
      System.out.println("init complete");
   }

   static {
      new SomeSingleton();
   }
}
```

Disadvantages of Kotlin ```object``` is that, if the initialization code requires some extra argument? Because a Kotlin object can’t have any constructor, you can’t pass any argument to it.

That's why we have to think about the other implementation of Singleton as well
The most efficient way for doing that is by using the __SingletonHolder__

```kotlin
open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}
```

We can send any params to Singleton class by using the help of ```SingletonHolder```

```kotlin
class SingletonWithParam private constructor(message: String) {
    
    init {
            // you can to some initializations here
        }    

    companion object : SingletonHolder<SingletonWithParam, String>(::SingletonWithParam)
}
```

Implementation of both method : 

```kotlin
fun main() {
    println("Implementation without sending params")
    println("First call ->${SingletonWithoutParam.hashCode()}")
    println("Second call ->${SingletonWithoutParam.hashCode()}")
    println("Implementation with sending params")
    println("First call ->${SingletonWithParam.getInstance("First Call").hashCode()}")
    println("Second call ->${SingletonWithParam.getInstance("Second Call").hashCode()}")
}
```
