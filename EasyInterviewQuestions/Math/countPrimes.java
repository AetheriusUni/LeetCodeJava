class Solution 
{
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) 
        {
            isPrime[i] = true;
        }
    // Loop's ending condition is i * i < n instead of i < sqrt(n)
    // to avoid repeatedly calling an expensive function sqrt().
    // CHECKS FOR PRIMES, READ SIEVE OF ERATOSTHENES
    for (int i = 2; i * i < n; i++) 
    {
        // IF NUMBER ISN'T PRIME, CHECK NEXT NUMBER
        if (!isPrime[i])
        {
            continue;
        }
        // IF THE NUMBER IS PRIME, MARK OFF EVERY INCREMENT OF NUMBER
        // INCLUDING AND AFTER NUMBER^2 AKA n^2, n^2+n, n^2+2n, and so on...
        // AS FALSE AKA NOT PRIME
        for (int j = i * i; j < n; j += i) 
        {
            isPrime[j] = false;
        }
    }
    // COUNTING THE PRIMES WE FOUND FROM THE PREVIOUS FOR LOOPS
    int count = 0;
    for (int i = 2; i < n; i++) 
    {
        if (isPrime[i]) 
        {
            count++;
        }
    }
    return count;
    }
}
