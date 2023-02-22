It works perfect)

How it was planned to be:
1. here we will use insertion sort for the list as it provides sorting in online format and we can get element for O(log n) using bin search
2. Then I tried to apply some patterns - Builder for Book, Fabric for Stored->Book, Command for Command
3. And I made our storage a template class for more flexibility: 
	We have interface Stored, and Book implements it.

But I realised, that my code becomes too sophisticated because of generics.
And for using binary search we have to sort the list. But how should we get the book in that case? Put null here? Dangerous. So if we want to turn the book back, how will we do it? To the end? Then we need to sort it? To the place inside by id? 
I wanted to give an id for each book. So we can use it somehow. But it will not help, because the list is not stable and not sorted, so search will be still O(n)
Maybe HashMap? Maybe. Store element and the num of it. Hmm good idea, but searching by caption will still be O(n). 

No tests ;\ But it is not the last HW)

Some notes:
1. I wonder how to make swapping faster. Can we just change links somehow?
2. Collection.swap(list, j, j - 1); Why doesn’t it working...
3. Maybe my problem was that I tried to make it work faster and so on, I looked at the problem from the side of algorithms. 
