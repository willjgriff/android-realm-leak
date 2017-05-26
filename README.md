# android-realm-leak
To aid in finding a solution to this stackoverflow post: http://stackoverflow.com/questions/39758862/possible-realm-memory-leak-in-android-when-creating-observable-from-where-clause

If the Realm Fragment is opened and backed out of multiple times, then a couple GC's are made and a Heap Dump, I have observed multiple instances of the Realm object and RealmResults are retained in memory. There are no instances of the Fragment which originally got the Realm reference.

Solved: https://github.com/realm/realm-java/issues/3552
