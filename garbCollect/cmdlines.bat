java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseSerialGC JavaApp.java
java -Xms3m -Xmx12m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelGC JavaApp.java
java -Xms9m -Xmx18m -Xmn3m -XX:PermSize=40m -XX:MaxPermSize=40m -XX:-UseParallelOldGC JavaApp.java
java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:-UseConcMarkSweepGC JavaApp.java
java -Xms2m -Xmx18m -Xmn1m -XX:PermSize=24m -XX:MaxPermSize=36m -XX:+UseSerialGC ?XX:+CMSConcurrentMTEnabled ?XX:+ConcGCThreads=2 JavaApp.java
java -Xms4m -Xmx16m -Xmn3m -XX:PermSize=24m -XX:MaxPermSize=32m -XX:+UseParallelGC -XX:ParallelGCThreads=2 JavaApp.java
java -Xms4m -Xmx16m -Xmn2m -XX:PermSize=12m -XX:MaxPermSize=12m -XX:+UseG1GC JavaApp.java