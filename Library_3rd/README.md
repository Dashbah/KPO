Now it has tests for parser and storage. I found some problems in my code (better to say architecture). It's difficult to test all methods 
because some important of them that contain logic are private. And the second thing is about console messages.
I can't test a lot of methods just because they require console input/output.

The old README about my algorithms suffering ->
______

How it was planned to be:

here we will use insertion sort for the list as it provides sorting in online format and we can get element for O(log n) using bin search
Then I tried to apply some patterns - Builder for Book, Fabric for Stored->Book, Command for Command
And I made our storage a template class for more flexibility: We have interface Stored, and Book implements it.
But I realised, that my code becomes too sophisticated because of generics. And for using binary search we have to sort the list. But how should we get the book in that case? Put null here? Dangerous. So if we want to turn the book back, how will we do it? To the end? Then we need to sort it? To the place inside by id? I wanted to give an id for each book. So we can use it somehow. But it will not help, because the list is not stable and not sorted, so search will be still O(n) Maybe HashMap? Maybe. Store element and the num of it. Hmm good idea, but searching by caption will still be O(n).

Some notes:

I wonder how to make swapping faster. Can we just change links somehow?
Collection.swap(list, j, j - 1); Why doesn’t it working...
Maybe my problem was that I tried to make it work faster and so on, I looked at the problem from the side of algorithms.
