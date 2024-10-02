# Which parent is used when?

In the `parent/pom.xml` there's an interesing feature: profile activation by packaging. 
Let's make use of this feature to see which parent is used when.

`mvn install -f parent`

As you can see, there's a `parent-1-SNAPSHOT-build.pom` that reflects the original build file.
But there's also a `parent-1-SNAPSHOT.pom`; this is the generated consumer pom for dependencies, transformed back to model 4.0.0.

The just installed pom has a profile, that activated when the packaging is jar.
It'll fail the build due to the alwaysFail enforcerRule
And there's an extra dependency: guava

Now let's make use of this (external) parent to build another project by running `mvn install -f jar`
Based on the modelVersion is might suggest that it can be build with Maven 3.
So let's see if we can indeed build it with Maven 3.
This fails, because the parent has modelVersion 4.1.0, which is not supported by Maven 3.
And now we'll try to build it with Maven 4.
This one fails as well. So this proofs that for your local build the `parent-1-SNAPSHOT-build.pom` is being used.

We need this jar anyway, so let's run `mvn install -f jar -Denforcer.skip`.

Let's use (consume) this jar with another project.
The enforcer-rule from the parent is only verified at buildtime, but the dependency on guava should be available.

So let's start with Maven 3 and run `mvn -f jar-consumer dependency:tree`
Hmm, where is guava?
Now let's try this with Maven 4:
Still, where is guava?
Here's something weird happening, so let's do this: `cd jar-consumer && mvn dependency:tree && cd ..`
Ah, there you are! ... at least with Maven 4. With Maven3 it is still missing.
